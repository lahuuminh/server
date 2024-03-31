package com.minhhuu.banhang.model;

public class Sanpham {
    private int masanpham;
    private double gia;
    private int soluong;
    private String theloai;
    private String ten;

    public Sanpham(int masanpham, double gia, int soluong, String theloai, String ten) {
        this.masanpham = masanpham;
        this.gia = gia;
        this.soluong = soluong;
        this.theloai = theloai;
        this.ten = ten;
    }

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "Sanpham{" +
                "masanpham=" + masanpham +
                ", gia=" + gia +
                ", soluong=" + soluong +
                ", theloai='" + theloai + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }
}
