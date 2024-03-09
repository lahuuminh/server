package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Test;
import com.minhhuu.banhang.repo.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = {"http://127.0.0.1:5503"})
public class TestController {
    @Autowired
    private TestRepo testRepo;
    @GetMapping("/{id}")
    public ResponseEntity<Test> getTest(@PathVariable Long id){
        Test t=testRepo.findById(id);

            return new ResponseEntity<>(t,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Test>>getAll(){
        List<Test>t=testRepo.findAll();
        return new ResponseEntity<>(t,HttpStatus.OK);
    }
}
