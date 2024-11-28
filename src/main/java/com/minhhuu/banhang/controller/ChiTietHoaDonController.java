package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.chitiethoadon;
import com.minhhuu.banhang.service.ChiTietHoaDonService;
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
   private ChiTietHoaDonService chiTietHoaDonService;

    @PostMapping("/add")
    public ResponseEntity<Message> addProduct(@RequestBody chitiethoadon chitiethoadon) {
       String message= chiTietHoaDonService.addProduct(chitiethoadon);
        return new ResponseEntity<>(new Message(message), HttpStatus.OK);
    }
}
