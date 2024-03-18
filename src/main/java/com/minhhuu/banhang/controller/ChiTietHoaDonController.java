package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.chitiethoadon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
@RequestMapping("/chitiethoadon")
public class ChiTietHoaDonController {
    @Autowired
  private  JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public ResponseEntity<Message> addProduct(@RequestBody chitiethoadon chitiethoadon) {
        System.out.println(chitiethoadon.toString());
        String sql = "INSERT INTO chitiethoadon (mahoadon, masanpham, gia, soluong) VALUES (?, ?, ?, ?)";
       int row = jdbcTemplate.update(sql, chitiethoadon.getMahoadon(), chitiethoadon.getMasanpham(), chitiethoadon.getGia(), chitiethoadon.getSoluong());
       System.out.println(row);
       System.out.println("chi tiet hoa don");
        return new ResponseEntity<>(new Message("thêm hóa đơn thành công"), HttpStatus.OK);
    }
}
