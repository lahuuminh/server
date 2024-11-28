package com.minhhuu.banhang.controller;
import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.PNReport;
import com.minhhuu.banhang.model.phieunhap;
import com.minhhuu.banhang.model.BHReport;
import com.minhhuu.banhang.service.PhieuNhapService;
import com.minhhuu.banhang.util.ConnectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/phieunhap")
public class PhieuNhapController {
    @Autowired
   private PhieuNhapService phieuNhapService;
    @GetMapping("/all")
    public List<phieunhap>getAll() throws SQLException {
      return phieuNhapService.getAll();
    }
@PostMapping("/add")
    public ResponseEntity<Message> insertPhieuNhap(@RequestBody phieunhap phieuNhap) throws SQLException {
        String message= phieuNhapService.insertPhieuNhap(phieuNhap);
              return new ResponseEntity<>(new Message(message),HttpStatus.OK);
    }

     @GetMapping("/nhaphang/{month}/{year}")
    public ResponseEntity<List<PNReport>> getSalesReportByMonthAndYear(@PathVariable Date month, @PathVariable Date year) throws SQLException {
      List<PNReport>l=phieuNhapService.getSalesReportByMonthAndYear(month, year);
        return new ResponseEntity<>(l,HttpStatus.OK);
    }
    @GetMapping("/banhang")
    public ResponseEntity<List<BHReport>> TKBH() throws SQLException {
        List<BHReport>l=phieuNhapService.TKBH();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

}



