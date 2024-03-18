package com.minhhuu.banhang.controller;


import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@org.springframework.stereotype.Controller
@RestController
public class ProductController {
    @Autowired(required = true)
    ProductRepo productRepo;
    @GetMapping("/findAllProduct")
    public ResponseEntity<List<sanpham>> findAll() {
        List<sanpham> productList = productRepo.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @GetMapping("/getAllSanPhamTrue")
    public List<sanpham> timKiemSanPham(
            @RequestParam(value = "ten", required = false) String tenSanPham,
            @RequestParam(value = "giaMin", required = false) Integer giaMin,
            @RequestParam(value = "giaMax", required = false) Integer giaMax,
            @RequestParam(value = "loai", required = false) Integer loaiSanPham) {
         System.out.println(tenSanPham);
        System.out.println(giaMin);  System.out.println(giaMax);
        System.out.println(loaiSanPham);



        // Gọi hàm tìm kiếm sản phẩm
        List<sanpham> sanPhams =productRepo.timKiemSanPham(tenSanPham, loaiSanPham, giaMin, giaMax);



        // Trả về view hiển thị danh sách sản phẩm
        return sanPhams;
    }
}
