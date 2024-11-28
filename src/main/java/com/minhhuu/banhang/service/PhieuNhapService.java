package com.minhhuu.banhang.service;

import com.minhhuu.banhang.model.BHReport;
import com.minhhuu.banhang.model.PNReport;
import com.minhhuu.banhang.model.phieunhap;
import com.minhhuu.banhang.repo.PhieuNhapRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PhieuNhapService {
    @Autowired
    private PhieuNhapRepo phieuNhapRepo;
    public List<phieunhap> getAll() throws SQLException {
        return phieuNhapRepo.getAll();
    }

    public String  insertPhieuNhap( phieunhap phieuNhap) throws SQLException {
      return phieuNhapRepo.insertPhieuNhap(phieuNhap);
    }


    public List<PNReport> getSalesReportByMonthAndYear(Date month, Date year) throws SQLException {
      return phieuNhapRepo.getSalesReportByMonthAndYear(month, year);
    }

    public List<BHReport> TKBH() throws SQLException {
        return phieuNhapRepo.TKBH();
    }
}
