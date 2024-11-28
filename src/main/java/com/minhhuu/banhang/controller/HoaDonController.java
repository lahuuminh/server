package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.*;
import com.minhhuu.banhang.repo.UserRepo;
import com.minhhuu.banhang.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/hoadon")

public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @PostMapping("/add")
    public void addhoadon(@RequestBody hoadon hoadon) {
        hoaDonService.addhoadon(hoadon);
    }
    @GetMapping("/find/{id}")
    public HoaDonResponse findHoaDonResponse(@PathVariable String id){
        return hoaDonService.findHoaDonResponse(id);
    }
   @PutMapping("/accept/{id}")
    public ResponseEntity<Message> updateHoadDon(@PathVariable String id) {
       String message = hoaDonService.updateHoadDon(id);
       return new ResponseEntity<>(new Message(message),HttpStatus.OK);
    }
   @PutMapping("/deny/{id}")
   public ResponseEntity<Message> denyHoadDon(@PathVariable String id){
        String message= hoaDonService.denyHoadDon(id);
       return new ResponseEntity<>(new Message(message),HttpStatus.OK);
   }
   @GetMapping("/user")
    public List<hoadon> getHDID(){
        return hoaDonService.getHDID();
   }

}
