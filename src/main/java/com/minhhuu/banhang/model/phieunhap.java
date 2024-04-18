package com.minhhuu.banhang.model;
import java.util.Date;
import java.util.List;

public class phieunhap {
    String maphieunhap;
    String congty;
    Date ngaynhap;
    Integer loai;
    String ten;

    public phieunhap(String maphieunhap, String congty, Date ngaynhap, Integer loai, String ten, Double tongtiennhap, Integer soluong, Integer masanpham, Double gianhap) {
        this.maphieunhap = maphieunhap;
        this.congty = congty;
        this.ngaynhap = ngaynhap;
        this.loai = loai;
        this.ten = ten;
        this.tongtiennhap = tongtiennhap;
        this.soluong = soluong;
        this.masanpham = masanpham;
        this.gianhap = gianhap;
    }

    @Override
    public String toString() {
        return "phieunhap{" +
                "maphieunhap='" + maphieunhap + '\'' +
                ", congty='" + congty + '\'' +
                ", ngaynhap=" + ngaynhap +
                ", loai=" + loai +
                ", ten='" + ten + '\'' +
                ", tongtiennhap=" + tongtiennhap +
                ", soluong=" + soluong +
                ", masanpham=" + masanpham +
                ", gianhap=" + gianhap +
                '}';
    }

    Double tongtiennhap;
    Integer soluong;
    Integer masanpham;
    Double gianhap;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getGianhap() {
        return gianhap;
    }

    public void setGianhap(Double gianhap) {
        this.gianhap = gianhap;
    }



    public phieunhap() {
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getCongty() {
        return congty;
    }

    public void setCongty(String congty) {
        this.congty = congty;
    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public Integer getLoai() {
        return loai;
    }

    public void setLoai(Integer loai) {
        this.loai = loai;
    }

    public Double getTongtiennhap() {
        return tongtiennhap;
    }

    public void setTongtiennhap(Double tongtiennhap) {
        this.tongtiennhap = tongtiennhap;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(Integer masanpham) {
        this.masanpham = masanpham;
    }

    public phieunhap(String maphieunhap, String congty, Date ngaynhap, Integer loai, Double tongtiennhap, Integer soluong, Integer masanpham) {
        this.maphieunhap = maphieunhap;
        this.congty = congty;
        this.ngaynhap = ngaynhap;
        this.loai = loai;
        this.tongtiennhap = tongtiennhap;
        this.soluong = soluong;
        this.masanpham = masanpham;
    }


}