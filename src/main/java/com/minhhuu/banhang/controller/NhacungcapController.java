package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Nhacungcap;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhacungcapController {
    private Connection connection;
    private final String url;
    private final String username;
    private final String password;

    public NhacungcapController(String url, String username, String password) {
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

    public void addNhacungcap(Nhacungcap nhacungcap) throws SQLException {
        String query = "INSERT INTO nhacungcap (mancc, Ten, Diachi, Sodienthoai, Email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nhacungcap.getMancc());
            preparedStatement.setString(2, nhacungcap.getTen());
            preparedStatement.setString(3, nhacungcap.getDiachi());
            preparedStatement.setString(4, nhacungcap.getSodienthoai());
            preparedStatement.setString(5, nhacungcap.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhà cung cấp đã được thêm vào cơ sở dữ liệu thành công.");
            } else {
                System.out.println("Thêm nhà cung cấp vào cơ sở dữ liệu thất bại.");
            }
        }
    }

    public void updateNhacungcap(Nhacungcap nhacungcap) throws SQLException {
        String query = "UPDATE nhacungcap SET Ten = ?, Diachi = ?, Sodienthoai = ?, Email = ? WHERE mancc = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, nhacungcap.getTen());
            preparedStatement.setString(2, nhacungcap.getDiachi());
            preparedStatement.setString(3, nhacungcap.getSodienthoai());
            preparedStatement.setString(4, nhacungcap.getEmail());
            preparedStatement.setString(5, nhacungcap.getMancc());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thông tin của nhà cung cấp đã được cập nhật thành công.");
            } else {
                System.out.println("Cập nhật thông tin của nhà cung cấp thất bại.");
            }
        }
    }

    public void deleteNhacungcap(String manhacungcap) throws SQLException {
        String query = "DELETE FROM nhacungcap WHERE mancc = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, manhacungcap);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nhà cung cấp đã được xóa khỏi cơ sở dữ liệu thành công.");
            } else {
                System.out.println("Xóa nhà cung cấp khỏi cơ sở dữ liệu thất bại.");
            }
        }
    }

    public List<Nhacungcap> getAllNhacungcap() throws SQLException {
        List<Nhacungcap> nhacungcapList = new ArrayList<>();
        String query = "SELECT * FROM nhacungcap";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String Manhacungcap = resultSet.getString("mancc");
                String Ten = resultSet.getString("Ten");
                String Diachi = resultSet.getString("Diachi");
                String Sodienthoai = resultSet.getString("Sodienthoai");
                String Email = resultSet.getString("Email");

                Nhacungcap nhacungcap = new Nhacungcap(Manhacungcap, Ten, Diachi, Sodienthoai, Email);
                nhacungcapList.add(nhacungcap);
            }
        }

        return nhacungcapList;
    }

public Nhacungcap searchNhacungcap(String mancc) throws SQLException {
    String query = "SELECT * FROM nhacungcap WHERE Mancc = ?";
    Nhacungcap nhacungcap = null;
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, mancc);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String ten = resultSet.getString("Ten");
            String diachi = resultSet.getString("Diachi");
            String sodienthoai = resultSet.getString("Sodienthoai");
            String email = resultSet.getString("Email");
            nhacungcap = new Nhacungcap(mancc, ten, diachi, sodienthoai, email);
        }
    }
    return nhacungcap;
}}
