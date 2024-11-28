package com.minhhuu.banhang.repo;

import com.minhhuu.banhang.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class HoaDonRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepo userRepo;

    public HoaDonRepo() {
    }

    public void addhoadon(hoadon hoadon) {
        System.out.println(hoadon.toString());
        String sql = "INSERT INTO hoadon (mahoadon, trangthaihoadon, ngaymua, tongtien, user_id) VALUES (?, ?, ?, ?, ?)";
        int row=  jdbcTemplate.update(sql, hoadon.getMahoadon(), hoadon.getTrangthaihoadon(), hoadon.getNgaymua(), hoadon.getTongtien(), hoadon.getUser_id());
    }

    public HoaDonResponse findHoaDonResponse(String id){
        String sqltest = "select * from  hoadon where mahoadon=?";
        hoadon a= jdbcTemplate.queryForObject(sqltest, new Object[]{id},new RowMapper<hoadon>() {
            @Override
            public hoadon mapRow(ResultSet rs, int rowNum) throws SQLException {
                hoadon h=new hoadon();
                h.setMahoadon(rs.getString(1));
                h.setTrangthaihoadon(rs.getString(2));
                h.setNgaymua(rs.getDate(3));
                h.setTongtien(rs.getDouble(4));
                h.setUser_id(rs.getInt(5));
                return h;
            }
        });
        String sql1 = "SELECT * FROM chitiethoadon where mahoadon=?";
        List<chitiethoadon> l=jdbcTemplate.query(sql1, new Object[]{id}, new RowMapper<chitiethoadon>() {
            @Override
            public chitiethoadon mapRow(ResultSet rs, int rowNum) throws SQLException {
                chitiethoadon c=new chitiethoadon();
                c.setMahoadon(rs.getString(1));
                c.setMasanpham(rs.getInt(2));
                c.setGia(rs.getDouble(3));
                c.setSoluong(rs.getInt(4));
                return c;
            }
        });
        User u=userRepo.findById((long) a.getUser_id());
        HoaDonResponse hoaDonResponse=new HoaDonResponse();
        hoaDonResponse.setMahoadon(a.getMahoadon());
        hoaDonResponse.setNgaymua(a.getNgaymua());
        hoaDonResponse.setTongtien(a.getTongtien());
        hoaDonResponse.setTrangthaihoadon(a.getTrangthaihoadon());
        hoaDonResponse.setUser_id(a.getUser_id());
        hoaDonResponse.setChitiethoadonList(l);
        hoaDonResponse.setU(u);
        return hoaDonResponse;
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

    public String updateHoadDon(String id){
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
            return "thanh cong";
        }
        else{
            return"them khong thanh cong";
        }


    }

    public String denyHoadDon(String id){

        String sql = "UPDATE hoadon SET trangthaihoadon=? where mahoadon=?";

        int row= jdbcTemplate.update(sql,"Da Huy",id);
        System.out.println(row);
        if(row==0){
            throw new EmptyResultDataAccessException("Không tìm thấy hoa don với ID: " + id, 1);
        }else{
            return"Hủy thành công ";
        }
    }

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
