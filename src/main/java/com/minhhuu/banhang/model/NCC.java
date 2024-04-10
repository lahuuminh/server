package com.minhhuu.banhang.model;

public class NCC {
    private  Integer manhacungcap;
    private String ten;

    public NCC() {
    }

    private String diaChi;
    private String email;

    public Integer getManhacungcap() {
        return manhacungcap;
    }

    public NCC(Integer manhacungcap, String ten, String diaChi, String email, String soDienThoai) {
        this.manhacungcap = manhacungcap;
        this.ten = ten;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
    }

    public void setManhacungcap(Integer manhacungcap) {
        this.manhacungcap = manhacungcap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NCC{" +
                "manhacungcap=" + manhacungcap +
                ", ten='" + ten + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    private String soDienThoai;
}
