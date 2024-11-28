package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.NCC;
import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.repo.NhaCungCapRepo;
import com.minhhuu.banhang.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/nhacungcap")
@CrossOrigin
public class NCCController {
    @Autowired
   private NhaCungCapService nhaCungCapService;
    @GetMapping("/all")
    public List<NCC>findAll() throws SQLException {
        return nhaCungCapService.findAll();
    }
    @GetMapping("/{id}")
    public  NCC findById(@PathVariable Long id) throws SQLException {
       return nhaCungCapService.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Message>delete(@PathVariable Long id) throws SQLException {
        nhaCungCapService.deleteById(id);
        return new ResponseEntity<>(new Message("xoa thanh cong"), HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<Message>update(@RequestBody NCC ncc) throws SQLException {
        nhaCungCapService.update(ncc);
        return new ResponseEntity<>(new Message("sua thanh cong"), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Message>create(@RequestBody  NCC ncc) throws SQLException {
        nhaCungCapService.create(ncc);
        return new ResponseEntity<>(new Message("them thanh cong"), HttpStatus.OK);
    }
    @GetMapping("/getnhacungcap")
    public List<NCC> timKiemNCCByFieldAndOrder(
            @RequestParam(value = "ten", required = false) String ten,
            @RequestParam(value = "diachi", required = false) String diachi,
            @RequestParam(value = "email",required = false) String email)
    {
        // Gọi hàm tìm kiếm sản phẩm
        return nhaCungCapService.timKiemNCCByFieldAndOrder(ten, diachi, email);
    }
    @GetMapping("/nhacungcaporder/{id}")
    public ResponseEntity<List<NCC>>findById(@PathVariable String id) throws SQLException {
        List<NCC> sp= nhaCungCapService.order(id);
        return new ResponseEntity<>(sp,HttpStatus.OK);
    }
}
