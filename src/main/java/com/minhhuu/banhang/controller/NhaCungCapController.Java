package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.NhaCungCap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nhacungcap")
public class NhaCungCapController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getAll")
    public List<NhaCungCap> getAllNhaCungCap() {
        String sql = "SELECT * FROM nhacungcap";
        List<NhaCungCap> nhaCungCapList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            NhaCungCap nhaCungCap = new NhaCungCap();
            nhaCungCap.setId(rs.getInt("id"));
            nhaCungCap.setTen(rs.getString("ten"));
            nhaCungCap.setDiaChi(rs.getString("diachi"));
            nhaCungCap.setEmail(rs.getString("email"));
            nhaCungCap.setSoDienThoai(rs.getString("sodienthoai"));
            return nhaCungCap;
        });
        return nhaCungCapList;
    }

    // Thêm nhà cung cấp
    @PostMapping("/add")
    public ResponseEntity<Message> addNhaCungCap(@RequestBody NhaCungCap nhaCungCap) {
        String sql = "INSERT INTO nhacungcap (ten, diachi, email, sodienthoai) VALUES (?, ?, ?, ?)";
        int row = jdbcTemplate.update(sql, nhaCungCap.getTen(), nhaCungCap.getDiaChi(), nhaCungCap.getEmail(), nhaCungCap.getSoDienThoai());
        if (row > 0) {
            return new ResponseEntity<>(new Message("Thêm nhà cung cấp thành công"), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new Message("Thêm nhà cung cấp thất bại"), HttpStatus.BAD_REQUEST);
        }
    }

    // Xóa nhà cung cấp
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteNhaCungCap(@PathVariable int id) {
        String sql = "DELETE FROM nhacungcap WHERE id=?";
        int row = jdbcTemplate.update(sql, id);
        if (row > 0) {
            return new ResponseEntity<>(new Message("Xóa nhà cung cấp thành công"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Xóa nhà cung cấp thất bại"), HttpStatus.BAD_REQUEST);
        }
    }
}
