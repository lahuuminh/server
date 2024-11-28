package com.minhhuu.banhang.service;

import com.minhhuu.banhang.model.NCC;
import com.minhhuu.banhang.repo.NhaCungCapRepo;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Service
public class NhaCungCapService {
    private NhaCungCapRepo nhaCungCapRepo;
    public void update(NCC ncc) throws SQLException {
        nhaCungCapRepo.update(ncc);
    }
    public void deleteById(Long id) throws SQLException {
      nhaCungCapRepo.deleteById(id);
    }
    public  void create(NCC ncc) throws SQLException {
      nhaCungCapRepo.create(ncc);

    }
    public List<NCC> findAll() throws SQLException {
      return nhaCungCapRepo.findAll();
    }
    public NCC findById(Long id) throws SQLException {
        return nhaCungCapRepo.findById(id);
    }

    public List<NCC> timKiemNCCByFieldAndOrder(String ten, String diachi, String email) {
      return nhaCungCapRepo.timKiemNCCByFieldAndOrder(ten, diachi, email);
    }

    public List<NCC> order(String id) throws SQLException {
        return nhaCungCapRepo.order(id);
    }
}
