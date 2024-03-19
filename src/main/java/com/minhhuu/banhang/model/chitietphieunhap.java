package com.minhhuu.banhang.model;

public class chitietphieunhap {
        String Maphieunhap;
        int masanpham;
        Double gia;
        int soluong;

    public chitietphieunhap(String Maphieunhap, int masanpham, Double gia, int soluong){
        this.Maphieunhap = Maphieunhap;
        this.masanpham = masanpham;
        this.gia = gia;
        this.soluong = soluong;
    }
    public chitietphieunhap() {

    }
    public String getMaphieunhap() {
        return Maphieunhap;
    }

    public int getmasanpham() {
        return masanpham;
    }

    public Double gia() {
        return gia;
    }
    public int soluong() {
        return soluong;
    }
    public void setMaphieunhap(String Maphieunhap){
        this.Maphieunhap = Maphieunhap;
    }

    public void setmasanpham(int masanpham) {
        this.masanpham = masanpham;
    }
    public void setgia(Double gia) {
        this.gia = gia;
    }
    public void setSoluong(int soluong){
        this.soluong = soluong;
    }
    @Override
    public String toString() {
        return "hoadon{" +
                "maphieunhap='" + Maphieunhap + '\'' +
                ", ngaynhap='" + masanpham + '\'' +
                ", tongtiennhap=" + gia +
                ", manhacungcap=" + soluong +
                '}';
    }
    }   
