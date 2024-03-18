package com.minhhuu.banhang.model;
import java.util.ArrayList;
import java.util.List;

public class sanpham {
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

    public int getTheloai() {
        return theloai;
    }

    public void setTheloai(int theloai) {
        this.theloai = theloai;
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

    private int masanpham;
    private Double gia;
    private int soluong;
    private int theloai;
    private String ten;
    private List<hinhanh> listimg;
    public sanpham(int masanpham, Double price, int count, int type, String name){
        this.masanpham=masanpham;
        this.gia=price;
        this.soluong=count;
        this.theloai=type;
        this.ten=name;
        this.listimg = new ArrayList<>();
    }
    public sanpham(int masanpham, Double price, int count, int type, String name, List<hinhanh> listimg){
        this.masanpham=masanpham;
        this.gia=price;
        this.soluong=count;
        this.theloai=type;
        this.ten=name;
       this.listimg=listimg;
    }
    public sanpham(){}
    public void addImage(hinhanh image) {
       listimg.add(image);
    }
}
