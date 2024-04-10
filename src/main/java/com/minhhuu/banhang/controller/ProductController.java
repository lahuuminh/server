package com.minhhuu.banhang.controller;


import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
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
    @DeleteMapping("/sanpham/{id}")
    public ResponseEntity<Message> deleteById(@PathVariable Long id) throws SQLException {
         productRepo.deleteById(id);
        return new ResponseEntity<>(new Message("xoa thanh cong"), HttpStatus.OK);
    }

    @GetMapping("/getAllSanPhamTrue")
    public List<sanpham> timKiemSanPham(
            @RequestParam(value = "ten", required = false) String tenSanPham,
            @RequestParam(value = "giaMin", required = false,defaultValue = "1") Integer giaMin,
            @RequestParam(value = "giaMax", required = false,defaultValue = "") Integer giaMax,
            @RequestParam(value = "loai", required = false) Integer loaiSanPham) {
         System.out.println(tenSanPham);
        System.out.println(giaMin);  System.out.println(giaMax);
        System.out.println(loaiSanPham);



        // Gọi hàm tìm kiếm sản phẩm
        List<sanpham> sanPhams =productRepo.timKiemSanPham(tenSanPham, loaiSanPham, giaMin, giaMax);



        // Trả về view hiển thị danh sách sản phẩm
        return sanPhams;
    }
    @GetMapping("/getsanpham")
    public List<sanpham> timKiemSanPhamByFieldAndOrder(
            @RequestParam(value = "ten", required = false) String tenSanPham,
            @RequestParam(value = "giamin", required = false,defaultValue ="1.0") Double giaMin ,
            @RequestParam(value = "giamax", required = false,defaultValue ="1000000.0") Double giaMax,
            @RequestParam(value = "loai", required = false) String loaiSanPham
         )

    {
        System.out.println(tenSanPham);
        System.out.println(giaMin);  System.out.println(giaMax);
        System.out.println(loaiSanPham);




        // Gọi hàm tìm kiếm sản phẩm
        List<sanpham> sanPhams =productRepo.timKiemSanPhamByFieldAndOrder(tenSanPham, loaiSanPham, giaMin, giaMax);



        // Trả về view hiển thị danh sách sản phẩm
        return sanPhams;
    }
    @PostMapping("/sanpham/add")
    public  ResponseEntity<Message>create(@RequestBody sanpham sp) throws SQLException {
        System.out.println(sp);
        productRepo.create(sp);
        return new ResponseEntity<>(new Message("them thanh cong"),HttpStatus.OK);
    }
@GetMapping("/sanpham/{id}")
    public ResponseEntity<sanpham>findById(@PathVariable Long id){
       sanpham sp= productRepo.findById(id);
       return new ResponseEntity<>(sp,HttpStatus.OK);
}
    @GetMapping("/sanphamorder/{id}")
    public ResponseEntity<List<sanpham>>findById(@PathVariable String id) throws SQLException {
        List<sanpham> sp= productRepo.order(id);
        return new ResponseEntity<>(sp,HttpStatus.OK);
    }
@PutMapping("/sanpham")
        public ResponseEntity<Message>update(@RequestBody sanpham sp) throws SQLException {
        productRepo.update(sp);
    return new ResponseEntity<>(new Message("sua thanh cong"),HttpStatus.OK);
}


}
