package com.minhhuu.banhang.model;

public class BHReport {
    private int  masanpham;
    private double tongtien;

    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    @Override
    public String toString() {
        return "BHReport{" +
                "masanpham=" + masanpham +
                ", tongtien=" + tongtien +
                ", soluong=" + soluong +
                '}';
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public BHReport() {
    }

    public BHReport(int masanpham, double tongtien, int soluong) {
        this.masanpham = masanpham;
        this.tongtien = tongtien;
        this.soluong = soluong;
    }

    private int soluong;
}
