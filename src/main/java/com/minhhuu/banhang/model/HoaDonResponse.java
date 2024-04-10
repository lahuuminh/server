package com.minhhuu.banhang.model;

import java.util.Date;
import java.util.List;

public class HoaDonResponse {
   private String mahoadon;
   private String trangthaihoadon;
   private Date ngaymua;
  private double tongtien;
   private int user_id;


    public HoaDonResponse() {
    }

    public HoaDonResponse(String mahoadon, String trangthaihoadon, Date ngaymua, double tongtien, int user_id, List<chitiethoadon> chitiethoadonList, User u) {
        this.mahoadon = mahoadon;
        this.trangthaihoadon = trangthaihoadon;
        this.ngaymua = ngaymua;
        this.tongtien = tongtien;
        this.user_id = user_id;
        this.chitiethoadonList = chitiethoadonList;
        this.u = u;
    }

    @Override
    public String toString() {
        return "HoaDonResponse{" +
                "mahoadon='" + mahoadon + '\'' +
                ", trangthaihoadon='" + trangthaihoadon + '\'' +
                ", ngaymua=" + ngaymua +
                ", tongtien=" + tongtien +
                ", user_id=" + user_id +
                ", chitiethoadonList=" + chitiethoadonList +
                ", u=" + u +
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
        return ngaymua;
    }

    public void setNgaymua(Date ngaymua) {
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

    public List<chitiethoadon> getChitiethoadonList() {
        return chitiethoadonList;
    }

    public void setChitiethoadonList(List<chitiethoadon> chitiethoadonList) {
        this.chitiethoadonList = chitiethoadonList;
    }

    private List<chitiethoadon> chitiethoadonList;


    private User u;

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
