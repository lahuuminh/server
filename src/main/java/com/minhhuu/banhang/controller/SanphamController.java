package controller;

import model.Sanpham;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanphamController {
    private Connection connection;
    private final String url;
    private final String username;
    private final String password;

    public SanphamController(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
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

    public void addSanpham(Sanpham sanpham) throws SQLException {
        String query = "INSERT INTO sanpham (Masanpham, Gia, Soluong, Theloai, Ten) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sanpham.getMasanpham());
            preparedStatement.setDouble(2, sanpham.getGia());
            preparedStatement.setInt(3, sanpham.getSoluong());
            preparedStatement.setString(4, sanpham.getTheloai());
            preparedStatement.setString(5, sanpham.getTen());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sản phẩm đã được thêm vào cơ sở dữ liệu thành công.");
            } else {
                System.out.println("Thêm sản phẩm vào cơ sở dữ liệu thất bại.");
            }
        }
    }

    public void updateSanpham(Sanpham sanpham) throws SQLException {
        String query = "UPDATE sanpham SET Gia = ?, Soluong = ?, Theloai = ?, Ten = ? WHERE Masanpham = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, sanpham.getGia());
            preparedStatement.setInt(2, sanpham.getSoluong());
            preparedStatement.setString(3, sanpham.getTheloai());
            preparedStatement.setString(4, sanpham.getTen());
            preparedStatement.setInt(5, sanpham.getMasanpham());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thông tin của sản phẩm đã được cập nhật thành công.");
            } else {
                System.out.println("Cập nhật thông tin của sản phẩm thất bại.");
            }
        }
    }

    public void deleteSanpham(int masanpham) throws SQLException {
        String query = "DELETE FROM sanpham WHERE Masanpham = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, masanpham);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Sản phẩm đã được xóa khỏi cơ sở dữ liệu thành công.");
            } else {
                System.out.println("Xóa sản phẩm khỏi cơ sở dữ liệu thất bại.");
            }
        }
    }

    public List<Sanpham> getAllSanpham() throws SQLException {
        List<Sanpham> sanphamList = new ArrayList<>();
        String query = "SELECT * FROM sanpham";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int masanpham = resultSet.getInt("Masanpham");
                double gia = resultSet.getDouble("Gia");
                int soluong = resultSet.getInt("Soluong");
                String theloai = resultSet.getString("Theloai");
                String ten = resultSet.getString("Ten");

                Sanpham sanpham = new Sanpham(masanpham, gia, soluong, theloai, ten);
                sanphamList.add(sanpham);
            }
        }

        return sanphamList;
    }

public Sanpham searchSanpham(int masanpham) throws SQLException {
    String query = "SELECT * FROM sanpham WHERE Masanpham = ?";
    Sanpham sanpham = null;
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setInt(1, masanpham);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            double gia = resultSet.getDouble("Gia");
            int soluong = resultSet.getInt("Soluong");
            String theloai = resultSet.getString("Theloai");
            String ten = resultSet.getString("Ten");
            sanpham = new Sanpham(masanpham, gia, soluong, theloai, ten);
        }
    }
    return sanpham;
}
}
