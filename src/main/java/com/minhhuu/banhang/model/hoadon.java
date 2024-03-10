package com.minhhuu.banhang.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadon {
   String mahoadon;
   String trangthaihoadon;
   String ngaymua;
   double tongtien;

    @Override
    public String toString() {
        return "hoadon{" +
                "mahoadon='" + mahoadon + '\'' +
                ", trangthaihoadon='" + trangthaihoadon + '\'' +
                ", ngaymua='" + ngaymua + '\'' +
                ", tongtien=" + tongtien +
                ", user_id=" + user_id +
                '}';
    }

    public String getMahoadon() {

        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTrangthaihoadon() {
        return trangthaihoadon;
    }

    public void setTrangthaihoadon(String trangthaihoadon) {
        this.trangthaihoadon = trangthaihoadon;
    }

    public Date getNgaymua() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date ngayMuaDate = null;
        try {
            ngayMuaDate = sdf.parse(ngaymua);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return ngayMuaDate;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    int user_id;

    public hoadon(String mahoadon, String trangthaihoadon, String ngaymua, double tongtien, int user_id) {
        this.mahoadon = mahoadon;
        this.trangthaihoadon = trangthaihoadon;
        this.ngaymua = ngaymua;
        this.tongtien = tongtien;
        this.user_id = user_id;
    }
}
