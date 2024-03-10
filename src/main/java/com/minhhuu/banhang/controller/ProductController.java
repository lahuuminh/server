package com.minhhuu.banhang.controller;


import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
