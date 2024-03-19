package com.minhhuu.banhang.model;
import java.util.Date;
public class phieunhap {
    String Maphieunhap;
    Date Ngaynhap;
    Double Tongtiennhap;
    String Manhacungcap;
    String Trangthai;

    public phieunhap(String Maphieunhap, Date Ngaynhap, double Tongtiennhap, String Manhacungcap, String Trangthai ){
        this.Maphieunhap = Maphieunhap;
        this.Ngaynhap = Ngaynhap;
        this.Tongtiennhap = Tongtiennhap;
        this.Manhacungcap = Manhacungcap;
        this.Trangthai = Trangthai;
    }
    public phieunhap() {

    }
    public String getMaphieunhap(){
        return Maphieunhap;
    }

    public Date getNgaynhap(){
        return Ngaynhap;
    }
    
    public Double getTongtiennhap(){
        return Tongtiennhap;
    }

    public String getManhacungcap() {
        return Manhacungcap;
    }

    public String getTrangthai() {
        return Trangthai;
    }
    
    public void setMaphieunhap(String Maphieunhap) {
        this.Maphieunhap = Maphieunhap;
    }

    public void setNgaynhap(Date Ngaynhap){
        this.Ngaynhap = Ngaynhap;
    }

    public void setTongtiennhap(Double Tongtiennhap){
        this.Tongtiennhap = Tongtiennhap;
    }

    public void setManhacungcap(String Manhacungcap){
        this.Manhacungcap = Manhacungcap;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }

    @Override
    public String toString() {
        return "hoadon{" +
                "maphieunhap='" + Maphieunhap + '\'' +
                ", ngaynhap='" + Ngaynhap + '\'' +
                ", tongtiennhap=" + Tongtiennhap +
                ", manhacungcap=" + Manhacungcap +
                ", trangthai=" + Trangthai +
                '}';
    }
}