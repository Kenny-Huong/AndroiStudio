package com.example.bt22_7;

public class SinhVien {
    private String ma;
    private String ten;
    private String gioitinh;
    private double diem;

    public SinhVien(String ma, String ten, String gioitinh, double diem) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diem = diem;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
}
