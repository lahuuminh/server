package com.minhhuu.banhang.model;

public class ThongKeRes {
    private String ma;
    private  Double doanhthu;
  ;

    public ThongKeRes() {
    }

    public ThongKeRes(String ma, Double doanhthu) {
        this.ma = ma;
        this.doanhthu = doanhthu;
    }

    @Override
    public String toString() {
        return "ThongKeRes{" +
                "ma='" + ma + '\'' +
                ", doanhthu=" + doanhthu +
                '}';
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(Double doanhthu) {
        this.doanhthu = doanhthu;
    }
}
