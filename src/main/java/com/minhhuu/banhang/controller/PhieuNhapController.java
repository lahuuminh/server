//package com.minhhuu.banhang.controller;
//import com.minhhuu.banhang.model.phieunhap;
//import com.minhhuu.banhang.model.chitietphieunhap;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class PhieuNhapController {
//    private Connection connection;
//    private final String url;
//    private final String username;
//    private final String password;
//
//    public PhieuNhapController (String url, String username, String password) {
//        this.url = url;
//        this.username = username;
//        this.password = password;
//    }
//
//    public void connect() throws SQLException {
//        connection = DriverManager.getConnection(url, username, password);
//        System.out.println("Connected to database successfully.");
//    }
//
//    public void disconnect() throws SQLException {
//        if (connection != null && !connection.isClosed()) {
//            connection.close();
//            System.out.println("Disconnected from database.");
//        }
//    }
//
//    public void insertPhieuNhap(phieunhap phieuNhap) throws SQLException {
//        String query = "INSERT INTO phieunhap (Maphieunhap, Ngaynhap, Tongtiennhap, Manhacungcap, Trangthai) VALUES (?, ?, ?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, phieuNhap.getMaphieunhap());
//            preparedStatement.setDate(2, new java.sql.Date(phieuNhap.getNgaynhap().getTime()));
//            preparedStatement.setDouble(3, phieuNhap.getTongtiennhap());
//            preparedStatement.setString(4, phieuNhap.getManhacungcap());
//            preparedStatement.setString(5, phieuNhap.getTrangthai());
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Phiếu nhập đã được lưu trữ thành công trong cơ sở dữ liệu.");
//            } else {
//                System.out.println("Lưu trữ phiếu nhập thất bại.");
//            }
//        }
//    }
//
//    public List<phieunhap> getPhieuNhapByMonthAndYear(int month, int year) throws SQLException {
//        List<phieunhap> phieuNhapList = new ArrayList<>();
//        String query = "SELECT * FROM phieunhap WHERE MONTH(Ngaynhap) = ? AND YEAR(Ngaynhap) = ?";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setInt(1, month);
//            preparedStatement.setInt(2, year);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String Maphieunhap = resultSet.getString("Maphieunhap");
//                Date Ngaynhap = resultSet.getDate("Ngaynhap");
//                double Tongtiennhap = resultSet.getDouble("Tongtiennhap");
//                String Manhacungcap = resultSet.getString("Manhacungcap");
//                String Trangthai = resultSet.getString("Trangthai");
//
//                phieunhap phieuNhap = new phieunhap(Maphieunhap, Ngaynhap, Tongtiennhap, Manhacungcap, Trangthai);
//                phieuNhapList.add(phieuNhap);
//            }
//        }
//
//        return phieuNhapList;
//    }
//
//    public Map<String, Double> getSalesReportByMonthAndYear(int month, int year) throws SQLException {
//        Map<String, Double> salesReport = new HashMap<>();
//        String query = "SELECT Manhacungcap, SUM(Tongtiennhap) AS TongTienNhap FROM phieunhap WHERE MONTH(Ngaynhap) = ? AND YEAR(Ngaynhap) = ? GROUP BY Manhacungcap";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setInt(1, month);
//            preparedStatement.setInt(2, year);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String Manhacungcap = resultSet.getString("Manhacungcap");
//                double TongTienNhap = resultSet.getDouble("TongTienNhap");
//
//                salesReport.put(Manhacungcap, TongTienNhap);
//            }
//        }
//
//        return salesReport;
//    }
//}
//
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
//            for (phieunhap phieuNhap : phieuNhapList) {
//                System.out.println(phieuNhap.toString());
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
//
