package com.minhhuu.banhang.controller;
import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.PNReport;
import com.minhhuu.banhang.model.phieunhap;
import com.minhhuu.banhang.model.BHReport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/phieunhap")
public class PhieuNhapController {
    private Connection connection;
    private final String url="jdbc:mysql://localhost:3306/banhang";
    private final String username="root";
    private final String password="minhmankieu456";



    public PhieuNhapController() throws SQLException {
        connect();
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database successfully.");
    }

    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Disconnected from database.");
        }
    }
    public int checkall(phieunhap a) throws SQLException {
        String sql="select * from sanpham where ten like ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"%"+a.getTen()+"%");
      ResultSet rs=  preparedStatement.executeQuery();
       if(rs.next()){
           return rs.getInt("masanpham");
       }
       return -1;
    }
    public String checkncc(phieunhap a) throws SQLException {
        String sql="select * from nhacungcap where ten like ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,"%"+a.getCongty()+"%");
        ResultSet rs=  preparedStatement.executeQuery();
        if(rs.next()){
            System.out.println(1);
          return  rs.getString("ten");
        }
        return null;
    }
    @GetMapping("/all")
    public List<phieunhap>getAll() throws SQLException {
        List<phieunhap>l=new ArrayList<>();
        String sql="select * from phieunhap";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
       ResultSet rs= preparedStatement.executeQuery();
       while (rs.next()){
           phieunhap a=new phieunhap();
           a.setCongty(rs.getString("congty"));
           a.setMaphieunhap(rs.getString("maphieunhap"));
           a.setLoai(rs.getInt("loai"));
           a.setNgaynhap(rs.getDate("ngaynhap"));
           a.setMasanpham(rs.getInt("masanpham"));
           a.setTongtiennhap(rs.getDouble("tongtien"));
        a.setSoluong(rs.getInt("soluong"));
           l.add(a);
       }
       return l;
    }
@PostMapping("/add")
    public ResponseEntity<Message> insertPhieuNhap(@RequestBody phieunhap phieuNhap) throws SQLException {
        System.out.println(phieuNhap);
        int masanpham=-1;
        String tennhacungcap;
        if(checkall(phieuNhap)==-1){
            return new ResponseEntity<>(new Message("khong co san pham nao co ten nay"),HttpStatus.BAD_REQUEST);
        }
        if(checkncc(phieuNhap)==null){
            return new ResponseEntity<>(new Message("khong co nha cung cap nao co ten nay"),HttpStatus.BAD_REQUEST);
        }
            masanpham=checkall(phieuNhap);
        tennhacungcap=checkncc(phieuNhap);
        String sqltest="select * from sanpham where masanpham=?";
        PreparedStatement preparedStatement2=connection.prepareStatement(sqltest);
        preparedStatement2.setInt(1,masanpham);
        ResultSet rstest=preparedStatement2.executeQuery();
        rstest.next();
        int soluong=rstest.getInt("soluong");
            String sql1="update sanpham set soluong =? where masanpham=?";
            PreparedStatement preparedStatement1=connection.prepareStatement(sql1);
            preparedStatement1.setInt(1,phieuNhap.getSoluong()+soluong);
            preparedStatement1.setInt(2,masanpham);
            preparedStatement1.executeUpdate();

        double tong=phieuNhap.getSoluong()*phieuNhap.getGianhap();
        String query = "INSERT INTO phieunhap  VALUES (?, ?, ?, ?, ?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phieuNhap.getMaphieunhap());
            preparedStatement.setDate(2, new java.sql.Date(phieuNhap.getNgaynhap().getTime()));
            preparedStatement.setInt(3, phieuNhap.getLoai());
            preparedStatement.setDouble(4,tong);
            preparedStatement.setInt(5, phieuNhap.getSoluong());
            preparedStatement.setInt(6,masanpham);
           preparedStatement.setString(7,tennhacungcap);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {

                return new ResponseEntity<>(new Message("lap phieu nhap thanh cong"),HttpStatus.OK);

            } else {
                return new ResponseEntity<>(new Message("lap phieu nhap khong thanh cong"), HttpStatus.BAD_REQUEST);
            }
        }
    }

     @GetMapping("/nhaphang/{month}/{year}")
    public ResponseEntity<List<PNReport>> getSalesReportByMonthAndYear(@PathVariable Date month, @PathVariable Date year) throws SQLException {
      List<PNReport>l=new ArrayList<>();
        String query = "SELECT congty, SUM(tongtien) AS TongTienNhap,sum(soluong) as soluong FROM phieunhap WHERE ngaynhap between ? and ? GROUP BY congty";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1,new java.sql.Date(month.getTime()));
            preparedStatement.setDate(2, new java.sql.Date(year.getTime()));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String congty = resultSet.getString("congty");
                double tongtiennhap = resultSet.getDouble("TongTienNhap");
                int soluong=resultSet.getInt("soluong");
                PNReport pnReport=new PNReport();
                pnReport.setCongty(congty);
                pnReport.setSoluong(soluong);
                pnReport.setTongtiennhap(tongtiennhap);
                l.add(pnReport);
            }
        }

        return new ResponseEntity<>(l,HttpStatus.OK);
    }
    @GetMapping("/banhang")
    public ResponseEntity<List<BHReport>> TKBH() throws SQLException {
        List<BHReport>l=new ArrayList<>();

        String query = "SELECT sp.masanpham as masanpham,sum(c.soluong) as soluong ,sum(c.soluong*c.gia) as tongtien FROM sanpham as sp left join chitiethoadon  as c on sp.masanpham=c.masanpham  GROUP BY sp.masanpham";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                BHReport bhReport=new BHReport();
               int masanpham= resultSet.getInt("masanpham");
               int soluong=resultSet.getInt("soluong");
               double tongtien=resultSet.getDouble("tongtien");
               bhReport.setMasanpham(masanpham);
               bhReport.setSoluong(soluong);
               bhReport.setTongtien(tongtien);
               l.add(bhReport);
            }
        }

        return new ResponseEntity<>(l,HttpStatus.OK);
    }

}


//public class Main {
//    public static void main(String[] args) {
//        PhieuNhapController databaseManager = new PhieuNhapController("jdbc:mysql://localhost:3306/your_database", "username", "password");
//
//        try {
//            databaseManager.connect();
//
//            // Lập phiếu nhập và nhập hàng vào kho
//            phieunhap phieuNhap = new phieunhap("PN001", new Date(), 1000.0, "NCC001", "Mới");
//            databaseManager.insertPhieuNhap(phieuNhap);
//
//            // Xem và thống kê lịch sử nhập kho theo tháng và năm
//            List<phieunhap> phieuNhapList = databaseManager.getPhieuNhapByMonthAndYear(3, 2024);
//            System.out.println("Lịch sử nhập kho cho tháng 3 năm 2024:");
//            for (phieunhap a : phieuNhapList) {
//                System.out.println(a.toString());
//            }
//
//            // Xem thống kê, báo cáo bán hàng cho tháng và năm
//            Map<String, Double> salesReport = databaseManager.getSalesReportByMonthAndYear(3, 2024);
//            System.out.println("Báo cáo bán hàng cho tháng 3 năm 2024:");
//            for (Map.Entry<String, Double> entry : salesReport.entrySet()) {
//                System.out.println("Nhà cung cấp: " + entry.getKey() + ", Tổng tiền nhập hàng: " + entry.getValue());
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                databaseManager.disconnect();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

