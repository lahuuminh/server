package com.minhhuu.banhang.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.model.hinhanh;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ProductRepo {
    private  String connectionUrl="jdbc:mysql://localhost:3306/banhang";
    private  String username="root";
    private String password="minhmankieu456";
    @Autowired
    private JdbcTemplate jdbcTemplate;
private Connection connection;
    {
        try {
            connection = DriverManager.getConnection(connectionUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<sanpham> findAll() {
        List<sanpham> list_product = new ArrayList<>();
        List<hinhanh> list_img = new ArrayList<>();
        String sql_product = "SELECT * FROM sanpham";
        String sql_img = "SELECT p.masanpham, i.url\n" +
                "        FROM sanpham AS p INNER JOIN hinhanh AS i ON p.masanpham = i.masanpham"; // Sử dụng JOIN để tối ưu hóa
        try {
            Statement statement1 = connection.createStatement();
            Statement statement2=connection.createStatement();
            // Thực thi truy vấn product và xử lý kết quả
            ResultSet resultSet_product = statement1.executeQuery(sql_product);
            while (resultSet_product.next()) {
                int masanpham = Integer.parseInt(resultSet_product.getString("masanpham"));
                Double gia = Double.valueOf(resultSet_product.getString("gia"));
                int soluong = Integer.parseInt(resultSet_product.getString("soluong"));
                int theloai = Integer.parseInt(resultSet_product.getString("theloai"));
                String ten= resultSet_product.getString("ten");
                String img_query = "SELECT url FROM hinhanh WHERE masanpham=" + masanpham;
                ResultSet resultSet_img = statement2.executeQuery(img_query);
                while (resultSet_img.next()) {
                    String url = resultSet_img.getString("url");
                    hinhanh image = new hinhanh(url);

                    list_img.add(image);
                }
                sanpham product = new sanpham(masanpham, gia, soluong,theloai,ten);
                for (hinhanh img: list_img) {
                    product.addImage(img);
                }
                list_product.add(product);
                list_img.clear();
            }
            return list_product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public sanpham findById(Long id) {
        sanpham list_product = new sanpham();
        List<hinhanh> list_img = new ArrayList<>();
        String sql_product = "SELECT * FROM sanpham where masanpham="+id;
        String sql_img = "SELECT p.masanpham, i.url\n" +
                "        FROM sanpham AS p INNER JOIN hinhanh AS i ON p.masanpham = i.masanpham where p.masanpham="+id; // Sử dụng JOIN để tối ưu hóa
        try {
            Statement statement1 = connection.createStatement();
            Statement statement2=connection.createStatement();
            // Thực thi truy vấn product và xử lý kết quả
            ResultSet resultSet_product = statement1.executeQuery(sql_product);
            if(resultSet_product.next()) {
                int masanpham = Integer.parseInt(resultSet_product.getString("masanpham"));
                list_product.setMasanpham(masanpham);
                Double gia = Double.valueOf(resultSet_product.getString("gia"));
                list_product.setGia(gia);
                int soluong = Integer.parseInt(resultSet_product.getString("soluong"));
                list_product.setSoluong(soluong);
                int theloai = Integer.parseInt(resultSet_product.getString("theloai"));
                list_product.setTheloai(theloai);
                String ten= resultSet_product.getString("ten");
                list_product.setTen(ten);
                String img_query = "SELECT url FROM hinhanh WHERE masanpham=" + masanpham;
                ResultSet resultSet_img = statement2.executeQuery(img_query);
                while (resultSet_img.next()) {
                    String url = resultSet_img.getString("url");
                    hinhanh image = new hinhanh(url);

                    list_img.add(image);
                }
                sanpham product = new sanpham(masanpham, gia, soluong,theloai,ten);
                for (hinhanh img: list_img) {
                    product.addImage(img);
                }
              list_product.setListimg(list_img);
            }
           return list_product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM sanpham WHERE masanpham = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setLong(1,id);
        int row=  preparedStatement.executeUpdate();
        if(row==0){
            throw new EmptyResultDataAccessException("Không tìm thấy bản ghi với ID: " + id, 1);
        }
    }
    public void update(sanpham sp) throws SQLException {

        System.out.println(sp);
        String sql = "UPDATE sanpham SET gia=?,soluong=?,theloai=?,ten=? where  masanpham =?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

         preparedStatement.setDouble(1,sp.getGia());
        preparedStatement.setInt(2,sp.getSoluong());
        preparedStatement.setInt(3,sp.getTheloai());
        preparedStatement.setString(4,sp.getTen());
        preparedStatement.setInt(5,sp.getMasanpham());
        int row=preparedStatement.executeUpdate();
        System.out.println(row);
        if(row==0){
            throw new EmptyResultDataAccessException("Không tìm thấy bản ghi với ID: "+sp.getMasanpham(), 1);
        }
    }
    public List<sanpham> timKiemSanPham(String ten ,int loai, int giaMin, int giaMax) {

        // Chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM sanpham WHERE ";
        if (!ten.isEmpty()) {
            sql += "tem LIKE ? AND ";
        }
        if (loai != 0) {
            sql += "theloai = ? AND ";
        }
        if (giaMin != 0 && giaMax != 0) {
            sql += "gia BETWEEN ? AND ? ";
        }

        // Loại bỏ "AND " dư thừa
        if (sql.endsWith("AND ")) {
            sql = sql.substring(0, sql.length() - 4);
        }

        // Chuẩn bị tham số
       List<Object>params=new ArrayList<>();
        if (!ten.isEmpty()) {
//            o[0]="%" + ten+ "%";
            params.add("%" + ten+ "%");
        }
        if (loai != 0) {
           params.add(loai);

        }
        if (giaMin != 0 && giaMax != 0) {
//            o[2]=giaMin;
//            o[3]=giaMax;
            params.add(giaMin);
            params.add(giaMax);
        }

        // Truy vấn dữ liệu
     Object o[]=   params.toArray();
        System.out.println(o);
        List<sanpham> sanPhams =jdbcTemplate.query(sql,o, new RowMapper<sanpham>() {
            @Override
            public sanpham mapRow(ResultSet rs, int rowNum) throws SQLException {
                sanpham s=new sanpham();
                s.setMasanpham(rs.getInt("masanpham"));
                s.setGia(rs.getDouble("gia"));
                s.setTen(rs.getString("ten"));
                s.setSoluong(rs.getInt("soluong"));
                s.setTheloai(rs.getInt("theloai"));
             return s;
            }
        });
return sanPhams;
    }
public void create(sanpham sp) throws SQLException {
        System.out.println(sp);
        String sql="insert into sanpham(gia,soluong,theloai,ten) values(?,?,?,?)";
        String sql2="insert into hinhanh(url,masanpham) values(?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setDouble(1,sp.getGia());
        preparedStatement.setInt(2,sp.getSoluong());
        preparedStatement.setInt(3,sp.getTheloai());
        preparedStatement.setString(4,sp.getTen());
      int row=  preparedStatement.executeUpdate();
      int id;
      if(row>0){
          ResultSet rs=preparedStatement.getGeneratedKeys();
          if(rs.next()){
              id=rs.getInt(1);
          }else{
              throw new RuntimeException("them khong thanh cong");

          }
      }else{
          throw new RuntimeException("them khong thanh cong");

      }
      System.out.println(id);
      PreparedStatement preparedStatement1=connection.prepareStatement(sql2);
      List<hinhanh>l=sp.getListimg();
      for(hinhanh a:l){
          preparedStatement1.setString(1,a.getUrl());
          preparedStatement1.setInt(2,id);
          preparedStatement1.executeUpdate();
      }

}


    public List<sanpham> timKiemSanPhamByFieldAndOrder(String ten, String loai, Double giaMin, Double giaMax) {
        // Chuẩn bị câu lệnh SQL
        String sql = "SELECT * FROM sanpham WHERE ";
        if (ten!=null&&!ten.isBlank()) {
            sql += "ten LIKE ? AND ";
        }
        boolean b = loai != null && !loai.isBlank() && !loai.equals("0");
        if (b) {
                sql += "theloai = ? AND ";
        }
        if (giaMin != 0.0 && giaMax != 0.0) {

            sql += "gia BETWEEN ? AND ? ";
        }

        // Loại bỏ "AND " dư thừa
        if (sql.endsWith("AND ")) {
            sql = sql.substring(0, sql.length() - 4);
        }

        // Chuẩn bị tham số
        List<Object>params=new ArrayList<>();
        if (ten!=null&&!ten.isBlank()) {
//            o[0]="%" + ten+ "%";
            params.add("%" + ten+ "%");
        }
        if (b) {
            params.add(loai);
        }
        if (giaMin != 0 && giaMax != 0) {
//            o[2]=giaMin;
//            o[3]=giaMax;
            params.add(giaMin);
            params.add(giaMax);
        }

        // Truy vấn dữ liệu
        Object o[]=   params.toArray();
        System.out.println(o);
        System.out.println(sql);
        String sql1="select * from hinhanh where anh_id=?";
        List<sanpham> sanPhams =jdbcTemplate.query(sql,o, new RowMapper<sanpham>() {
            @Override
            public sanpham mapRow(ResultSet rs, int rowNum) throws SQLException {

                sanpham s=new sanpham();
                s.setMasanpham(rs.getInt("masanpham"));
                System.out.println(rs.getInt("masanpham"));
                List<hinhanh>l=new ArrayList<>();
                String sql1="select * from hinhanh where masanpham=?";
                PreparedStatement preparedStatement=connection.prepareStatement(sql1);
                ResultSet resultSet= preparedStatement.executeQuery();
                while (resultSet.next()){
                    hinhanh a=new hinhanh();
                    a.setUrl(resultSet.getString("url"));
                    l.add(a);
                }
                s.setGia(rs.getDouble("gia"));
                s.setTen(rs.getString("ten"));
                s.setSoluong(rs.getInt("soluong"));
                s.setTheloai(rs.getInt("theloai"));
                s.setListimg(l);
                return s;
            }
        });

        return sanPhams;
    }

    public List<sanpham> order(String id) throws SQLException {
        String sql="select * from sanpham order by "+id;


        PreparedStatement preparedStatement=connection.prepareStatement(sql);

     ResultSet rs= preparedStatement.executeQuery();
     List<sanpham>l=new ArrayList<>();
     while (rs.next()){
         sanpham s=new sanpham();
         int masanpham = Integer.parseInt(rs.getString("masanpham"));
         System.out.println(masanpham);
         s.setMasanpham(masanpham);
         Double gia = Double.valueOf(rs.getString("gia"));
         s.setGia(gia);
         int soluong = Integer.parseInt(rs.getString("soluong"));
         s.setSoluong(soluong);
         int theloai = Integer.parseInt(rs.getString("theloai"));
         s.setTheloai(theloai);
         String ten= rs.getString("ten");
         s.setTen(ten);
         String img_query = "SELECT url FROM hinhanh WHERE masanpham=" + masanpham;
         PreparedStatement statement2=connection.prepareStatement(img_query);
         ResultSet resultSet_img = statement2.executeQuery(img_query);
         List<hinhanh>list_img=new ArrayList<>();
         while (resultSet_img.next()) {
             String url = resultSet_img.getString("url");
             hinhanh image = new hinhanh(url);

             list_img.add(image);
         }
         s.setListimg(list_img);
         l.add(s);
     }
     return l;
    }
}
