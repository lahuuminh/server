package com.minhhuu.banhang.service;
import com.minhhuu.banhang.model.chitiethoadon;
import com.minhhuu.banhang.repo.ChiTietHoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ChiTietHoaDonService {

    @Autowired
    private ChiTietHoaDonRepo chiTietHoaDonRepo;

    public String addProduct(chitiethoadon chitiethoadon) {
        return chiTietHoaDonRepo.addProduct(chitiethoadon);
    }
}
