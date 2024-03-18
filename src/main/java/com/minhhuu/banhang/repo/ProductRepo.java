package com.minhhuu.banhang.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.model.hinhanh;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {
    private  String connectionUrl="jdbc:mysql://localhost:3306/banhang";
    private  String username="root";
    private String password="";
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

}
