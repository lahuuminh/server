package com.minhhuu.banhang.service;

import com.minhhuu.banhang.model.hinhanh;
import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public List<sanpham> findAll() {
     return productRepo.findAll();
    }
    public sanpham findById(Long id) {
      return productRepo.findById(id);
    }
    public void deleteById(Long id) throws SQLException {
      productRepo.deleteById(id);
    }
    public void update(sanpham sp) throws SQLException {

     productRepo.update(sp);
    }
    public List<sanpham> timKiemSanPham(String ten ,int loai, int giaMin, int giaMax) {
        return productRepo.timKiemSanPham(ten, loai, giaMin, giaMax);
    }
    public void create(sanpham sp) throws SQLException {
      productRepo.create(sp);
    }


    public List<sanpham> timKiemSanPhamByFieldAndOrder(String ten, Integer loai, Double giaMin, Double giaMax) throws SQLException {
        return productRepo.timKiemSanPhamByFieldAndOrder(ten, loai, giaMin, giaMax);
    }

    public List<sanpham> order(String id) throws SQLException {
     return productRepo.order(id);
    }
}
