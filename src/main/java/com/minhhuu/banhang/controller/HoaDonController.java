package com.minhhuu.banhang.controller;

import com.minhhuu.banhang.model.Message;
import com.minhhuu.banhang.model.chitiethoadon;
import com.minhhuu.banhang.model.hoadon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/hoadon")

public class HoaDonController {
    @Autowired
   private JdbcTemplate jdbcTemplate;
    @PostMapping("/add")
    public void addhoadon(@RequestBody hoadon hoadon) {
        System.out.println(hoadon.toString());
        String sql = "INSERT INTO hoadon (mahoadon, trangthaihoadon, ngaymua, tongtien, user_id) VALUES (?, ?, ?, ?, ?)";
    int row=  jdbcTemplate.update(sql, hoadon.getMahoadon(), hoadon.getTrangthaihoadon(), hoadon.getNgaymua(), hoadon.getTongtien(), hoadon.getUser_id());
    System.out.println(row);

    }
    public  boolean check(List<chitiethoadon>l){
        String sql3="select soluong from sanpham where masanpham=?";
       for(chitiethoadon a:l){
           Integer soluong=jdbcTemplate.queryForObject(sql3,new Object[]{a.getMasanpham()},Integer.class);
           if(soluong==null){
               return false;
           }
           int rest=soluong-a.getSoluong();
           if(rest<0){
             return false;
           }
           System.out.println(soluong-a.getSoluong());
           System.out.println(a.getMasanpham());

       }
return  true;
    }
   @PutMapping("/accept/{id}")
    public ResponseEntity<Message> updateHoadDon(@PathVariable String id){
       String sqltest = "select user_id from  hoadon where mahoadon=?";
       Integer s = jdbcTemplate.queryForObject(sqltest, new Object[]{id},Integer.class);
       if(s==null){
           throw new EmptyResultDataAccessException("Không tìm thấy hoa don với ID: " + id, 1);
       }


System.out.println(id);
       String sql1 = "SELECT * FROM chitiethoadon where mahoadon=?";
       List<chitiethoadon>l=jdbcTemplate.query(sql1,new Object[]{id} ,

      (ResultSet rs, int rowNum) ->{
             chitiethoadon c=new chitiethoadon();
             c.setMahoadon(rs.getString(1));
             c.setMasanpham(rs.getInt(2));
             c.setGia(rs.getDouble(3));
             c.setSoluong(rs.getInt(4));
return c;

       });
       String sql2="Update sanpham Set soluong=? where masanpham=?";
      String sql3="select soluong from sanpham where masanpham=?";
if(check(l)) {
    l.forEach(a -> {
        Integer soluong = jdbcTemplate.queryForObject(sql3, new Object[]{a.getMasanpham()}, Integer.class);
        int rest = soluong - a.getSoluong();
        int row1 = jdbcTemplate.update(sql2, new Object[]{rest, a.getMasanpham()});
    });
    String sql = "UPDATE hoadon SET trangthaihoadon=? where mahoadon=?";
    int row= jdbcTemplate.update(sql,"Da Giao Hang",id);
    System.out.println(row);
    return new ResponseEntity<>(new Message("thanh cong"), HttpStatus.ACCEPTED);
}
    else{
        return new ResponseEntity<>(new Message("them khong thanh cong"), HttpStatus.OK);
    }


   }
   @PutMapping("/deny/{id}")
   public ResponseEntity<Message> denyHoadDon(@PathVariable String id){

       String sql = "UPDATE hoadon SET trangthaihoadon=? where mahoadon=?";

       int row= jdbcTemplate.update(sql,"Da Huy",id);
       System.out.println(row);
       if(row==0){
           throw new EmptyResultDataAccessException("Không tìm thấy hoa don với ID: " + id, 1);
       }else{
           return new ResponseEntity<>(new Message("Hủy thành công "),HttpStatus.OK);
       }
   }
   @GetMapping("/user")
    public List<hoadon> getHDID(){
        System.out.println(1);
        String sql="select * from hoadon ";
      List<hoadon>l = jdbcTemplate.query(sql,(ResultSet rs,int row)->{
            hoadon h=new hoadon();
            h.setMahoadon(rs.getString(1));
            h.setTrangthaihoadon(rs.getString(2));
            h.setNgaymua(rs.getDate(3));
            h.setTongtien(rs.getDouble(4));
            h.setUser_id(rs.getInt(5));
            return h;
        });
      return  l;
   }

}
