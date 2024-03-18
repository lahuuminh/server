package com.minhhuu.banhang.model;

public class chitiethoadon {
    String mahoadon;
    int masanpham;
    Double gia;

    public chitiethoadon() {
    }

    @Override
    public String toString() {
        return "chitiethoadon{" +
                "mahoadon='" + mahoadon + '\'' +
                ", masanpham=" + masanpham +
                ", gia=" + gia +
                ", soluong=" + soluong +
                '}';
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public chitiethoadon(String mahoadon, int masanpham, Double gia, int soluong) {
        this.mahoadon = mahoadon;
        this.masanpham = masanpham;
        this.gia = gia;
        this.soluong = soluong;
    }

    int soluong;
}
