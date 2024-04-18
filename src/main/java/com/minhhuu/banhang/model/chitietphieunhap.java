package com.minhhuu.banhang.model;

public class chitietphieunhap {
        String maphieunhap;
        int masanpham;
        Double gia;
        int soluong;

    public chitietphieunhap() {
    }

    public chitietphieunhap(String maphieunhap, int masanpham, Double gia, int soluong) {
        this.maphieunhap = maphieunhap;
        this.masanpham = masanpham;
        this.gia = gia;
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "chitietphieunhap{" +
                "maphieunhap='" + maphieunhap + '\'' +
                ", masanpham=" + masanpham +
                ", gia=" + gia +
                ", soluong=" + soluong +
                '}';
    }

    public String getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(String maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
