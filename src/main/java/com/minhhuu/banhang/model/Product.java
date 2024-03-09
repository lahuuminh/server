package com.minhhuu.banhang.model;
import java.util.ArrayList;
import java.util.List;

public class Product {
    public int getMasanpham() {
        return masanpham;
    }

    public void setMasanpham(int masanpham) {
        this.masanpham = masanpham;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getListimg() {
        return listimg;
    }

    public void setListimg(List<Image> listimg) {
        this.listimg = listimg;
    }

    private int masanpham;
    private Double price;
    private int count;
    private String type;
    private String name;
    private List<Image> listimg;
    public Product(int masanpham,Double price, int count,String type,String name){
        this.masanpham=masanpham;
        this.price=price;
        this.count=count;
        this.type=type;
        this.name=name;
        this.listimg = new ArrayList<>();
    }
    public Product(int masanpham,Double price, int count,String type,String name,List<Image> listimg){
        this.masanpham=masanpham;
        this.price=price;
        this.count=count;
        this.type=type;
        this.name=name;
       this.listimg=listimg;
    }
    public Product(){}
    public void addImage(Image image) {
       listimg.add(image);
    }
}
