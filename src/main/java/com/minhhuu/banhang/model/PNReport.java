package com.minhhuu.banhang.model;

public class PNReport {
    private  String congty;
    private int soluong;
    private double tongtiennhap;

    public PNReport(String congty, int soluong, double tongtiennhap) {
        this.congty = congty;
        this.soluong = soluong;
        this.tongtiennhap = tongtiennhap;
    }

    public String getCongty() {
        return congty;
    }

    @Override
    public String toString() {
        return "PNReport{" +
                "congty='" + congty + '\'' +
                ", soluong=" + soluong +
                ", tongtiennhap=" + tongtiennhap +
                '}';
    }

    public void setCongty(String congty) {
        this.congty = congty;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getTongtiennhap() {
        return tongtiennhap;
    }

    public void setTongtiennhap(double tongtiennhap) {
        this.tongtiennhap = tongtiennhap;
    }

    public PNReport() {
    }
}
