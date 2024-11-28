package com.minhhuu.banhang.repo;

import org.springframework.stereotype.Repository;
import com.minhhuu.banhang.model.chitiethoadon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
@Repository
public class ChiTietHoaDonRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addProduct(chitiethoadon chitiethoadon) {
        System.out.println(chitiethoadon.toString());
        String sql = "INSERT INTO chitiethoadon (mahoadon, masanpham, gia, soluong) VALUES (?, ?, ?, ?)";
        int row = jdbcTemplate.update(sql, chitiethoadon.getMahoadon(), chitiethoadon.getMasanpham(), chitiethoadon.getGia(), chitiethoadon.getSoluong());
        System.out.println(row);
        System.out.println("chi tiet hoa don");
        return "thêm hóa đơn thành công";
    }
}
