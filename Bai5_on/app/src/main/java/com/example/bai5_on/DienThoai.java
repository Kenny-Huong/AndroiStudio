package com.example.bai5_on;

public class DienThoai {
    private int ma;
    private String ten;
    private String hang;
    private int gia;

    public DienThoai(int ma, String ten, String hang, int gia) {
        this.ma = ma;
        this.ten = ten;
        this.hang = hang;
        this.gia = gia;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Mã: " + ma +
                "\nTên:" + ten +
                "\nHãng: " + hang +
                "\nGiá: " + gia;
    }
}
