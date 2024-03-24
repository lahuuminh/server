package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sanpham")
public class SanPhamController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/getAll")
    public List<SanPham> getAllSanPham() {
        String sql = "SELECT * FROM sanpham";
        List<SanPham> sanPhamList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            SanPham sanPham = new SanPham();
            sanPham.setId(rs.getInt("id"));
            sanPham.setTen(rs.getString("ten"));
            sanPham.setGia(rs.getDouble("gia"));
            sanPham.setSoLuong(rs.getInt("soluong"));
            return sanPham;
        });
        return sanPhamList;
    }

    // Thêm sản phẩm
    @PostMapping("/add")
    public ResponseEntity<Message> addSanPham(@RequestBody SanPham sanPham) {
        String sql = "INSERT INTO sanpham (ten, gia, soluong) VALUES (?, ?, ?)";
        int row = jdbcTemplate.update(sql, sanPham.getTen(), sanPham.getGia(), sanPham.getSoLuong());
        if (row > 0) {
            return new ResponseEntity<>(new Message("Thêm sản phẩm thành công"), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new Message("Thêm sản phẩm thất bại"), HttpStatus.BAD_REQUEST);
        }
    }

    // Xóa sản phẩm
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Message> deleteSanPham(@PathVariable int id) {
        String sql = "DELETE FROM sanpham WHERE id=?";
        int row = jdbcTemplate.update(sql, id);
        if (row > 0) {
            return new ResponseEntity<>(new Message("Xóa sản phẩm thành công"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Message("Xóa sản phẩm thất bại"), HttpStatus.BAD_REQUEST);
        }
//Sap xep san pham
   public ResponseEntity<List<sanpham>> sortByProductName() {
    List<sanpham> sortedProducts = productRepo.sortByProductName();
    return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
}
    }


}

