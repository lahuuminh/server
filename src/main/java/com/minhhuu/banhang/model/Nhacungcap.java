package model;

public class Nhacungcap {
    private String mancc;
    private String ten;
    private String diachi;
    private String sodienthoai;
    private String email;

    public Nhacungcap() {
        // Constructor mặc định
    }

    public Nhacungcap(String mancc, String ten, String diachi, String sodienthoai, String email) {
        this.mancc = mancc;
        this.ten = ten;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.email = email;
    }

    // Các phương thức getter và setter

    public String getMancc() {
        return mancc;
    }

    public void setMancc(String manhacungcap) {
        this.mancc = manhacungcap;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Phương thức toString để hiển thị thông tin đối tượng

    @Override
    public String toString() {
        return "Nhacungcap{" +
                "manhacungcap='" + mancc + '\'' +
                ", ten='" + ten + '\'' +
                ", diachi='" + diachi + '\'' +
                ", sodienthoai='" + sodienthoai + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
