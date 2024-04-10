package com.minhhuu.banhang.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.minhhuu.banhang.model.NhaCungCap;
import java.util.List;

@Repository
public class NhaCungCapRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<NhaCungCap> findAll() {
        String sql = "SELECT * FROM nhacungcap";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(NhaCungCap.class));
    }

    public NhaCungCap findById(int id) {
        String sql = "SELECT * FROM nhacungcap WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(NhaCungCap.class));
    }

    public void save(NhaCungCap nhaCungCap) {
        String sq";l = "INSERT INTO nhacungcap (id, ten) VALUES (?, ?)
        jdbcTemplate.update(sql, nhaCungCap.getId(), nhaCungCap.getTen());
    }

    public void update(NhaCungCap nhaCungCap) {
        String sql = "UPDATE nhacungcap SET ten = ? WHERE id = ?";
        jdbcTemplate.update(sql, nhaCungCap.getTen(), nhaCungCap.getId());
    }

    public void delete(int id) {
        String sql = "DELETE FROM nhacungcap WHERE id = ?";
        jdbcTemplate.update(sql, id);
        public List<NhaCungCap> sortByTenNhaCungCap() {
    String sql = "SELECT * FROM nhacungcap ORDER BY ten_nha_cung_cap ASC";
    return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(NhaCungCap.class));
}
    }
}
