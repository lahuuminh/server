package com.minhhuu.banhang.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class hoadon {
   String mahoadon;
   String trangthaihoadon;

    public hoadon(String mahoadon, String trangthaihoadon, Date ngaymua, double tongtien, int user_id) {
        this.mahoadon = mahoadon;
        this.trangthaihoadon = trangthaihoadon;
        this.ngaymua = ngaymua;
        this.tongtien = tongtien;
        this.user_id = user_id;
    }

    public hoadon() {
    }

    Date ngaymua;
   double tongtien;
    int user_id;

    public String getMahoadon() {
        return mahoadon;
    }

    public String getTrangthaihoadon() {
        return trangthaihoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public void setTrangthaihoadon(String trangthaihoadon) {
        this.trangthaihoadon = trangthaihoadon;
    }

    public void setNgaymua(Date ngaymua) {
        this.ngaymua = ngaymua;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getNgaymua() {
        return ngaymua;
    }

    public double getTongtien() {
        return tongtien;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "hoadon{" +
                "mahoadon='" + mahoadon + '\'' +
                ", trangthaihoadon='" + trangthaihoadon + '\'' +
                ", ngaymua=" + ngaymua +
                ", tongtien=" + tongtien +
                ", user_id=" + user_id +
                '}';
    }
}
