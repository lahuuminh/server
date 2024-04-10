package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.NCC;
import com.minhhuu.banhang.model.sanpham;
import com.minhhuu.banhang.repo.NhaCungCapRepo;
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
   private NhaCungCapRepo nhaCungCapRepo;
    @GetMapping("/all")
    public List<NCC>findAll() throws SQLException {
        return nhaCungCapRepo.findAll();
    }
    @GetMapping("/{id}")
    public  NCC findById(@PathVariable Long id) throws SQLException {
       return nhaCungCapRepo.findById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Message>delete(@PathVariable Long id) throws SQLException {
        nhaCungCapRepo.deleteById(id);
        return new ResponseEntity<>(new Message("xoa thanh cong"), HttpStatus.OK);
    }
    @PutMapping("")
    public ResponseEntity<Message>update(@RequestBody NCC ncc) throws SQLException {
        nhaCungCapRepo.update(ncc);
        return new ResponseEntity<>(new Message("sua thanh cong"), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Message>create(@RequestBody  NCC ncc) throws SQLException {
        nhaCungCapRepo.create(ncc);
        return new ResponseEntity<>(new Message("them thanh cong"), HttpStatus.OK);
    }
    @GetMapping("/getnhacungcap")
    public List<NCC> timKiemNCCByFieldAndOrder(
            @RequestParam(value = "ten", required = false) String ten,
            @RequestParam(value = "diachi", required = false) String diachi,
            @RequestParam(value = "email",required = false) String email)
    {
        System.out.println(ten);
        System.out.println(diachi);
        System.out.println(email);




        // Gọi hàm tìm kiếm sản phẩm
        List<NCC> sanPhams =nhaCungCapRepo.timKiemNCCByFieldAndOrder(ten,diachi,email);



        // Trả về view hiển thị danh sách sản phẩm
        return sanPhams;
    }
    @GetMapping("/nhacungcaporder/{id}")
    public ResponseEntity<List<NCC>>findById(@PathVariable String id) throws SQLException {
        List<NCC> sp= nhaCungCapRepo.order(id);
        return new ResponseEntity<>(sp,HttpStatus.OK);
    }
}
