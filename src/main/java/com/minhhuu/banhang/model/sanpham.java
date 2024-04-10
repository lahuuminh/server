package com.minhhuu.banhang.model;

import java.util.ArrayList;
import java.util.List;

public class sanpham {
    private int masanpham;
    private double gia;
    private int soluong;
    private int  theloai;
    private String ten;

    @Override
    public String toString() {
        return "sanpham{" +
                "masanpham=" + masanpham +
                ", gia=" + gia +
                ", soluong=" + soluong +
                ", theloai='" + theloai + '\'' +
                ", ten='" + ten + '\'' +
                ", listimg=" + listimg +
                '}';
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





    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<hinhanh> getListimg() {
        return listimg;
    }

    public void setListimg(List<hinhanh> listimg) {
        this.listimg = listimg;
    }

    public sanpham(int masanpham, double gia, int soluong, int theloai, String ten) {
        this.masanpham = masanpham;
        this.gia = gia;
        this.soluong = soluong;
        this.theloai = theloai;
        this.ten = ten;
    }

    public sanpham() {
    }

    public sanpham(int masanpham, double gia, int soluong, int theloai, String ten, List<hinhanh> listimg) {
        this.masanpham = masanpham;
        this.gia = gia;
        this.soluong = soluong;
        this.theloai = theloai;
        this.ten = ten;
        this.listimg = listimg;
    }

    public int getTheloai() {
        return theloai;
    }

    public void setTheloai(int theloai) {
        this.theloai = theloai;
    }

    private List<hinhanh>listimg=new ArrayList<>();


    public void addImage(hinhanh a){
        listimg.add(a);
    }

}
