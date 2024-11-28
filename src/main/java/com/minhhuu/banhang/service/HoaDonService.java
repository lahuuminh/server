package com.minhhuu.banhang.service;

import com.minhhuu.banhang.model.HoaDonResponse;
import com.minhhuu.banhang.model.User;
import com.minhhuu.banhang.model.chitiethoadon;
import com.minhhuu.banhang.model.hoadon;
import com.minhhuu.banhang.repo.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepo hoaDonRepo;
    public void addhoadon(hoadon hoadon) {
      hoaDonRepo.addhoadon(hoadon);
    }

    public HoaDonResponse findHoaDonResponse(String id){
     return hoaDonRepo.findHoaDonResponse(id);
    }


    public String updateHoadDon( String id){
        return hoaDonRepo.updateHoadDon(id);
    }

    public String denyHoadDon(String id){
        return hoaDonRepo.denyHoadDon(id);
    }

    public List<hoadon> getHDID(){
        return hoaDonRepo.getHDID();
    }
}
