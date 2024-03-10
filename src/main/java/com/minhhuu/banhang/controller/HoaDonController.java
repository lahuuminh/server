package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.hoadon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
@RequestMapping("/hoadon")

public class HoaDonController {
    @Autowired
   private JdbcTemplate jdbcTemplate;
    @PostMapping("/add")
    public void addhoadon(@RequestBody hoadon hoadon) {
        System.out.println(hoadon.toString());
        String sql = "INSERT INTO hoadon (mahoadon, trangthaihoadon, ngaymua, tongtien, user_id) VALUES (?, ?, ?, ?, ?)";
    int row=  jdbcTemplate.update(sql, hoadon.getMahoadon(), hoadon.getTrangthaihoadon(), hoadon.getNgaymua(), hoadon.getTongtien(), hoadon.getUser_id());
    System.out.println(row);

    }
}
