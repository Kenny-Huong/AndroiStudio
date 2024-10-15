package com.example.nguyenvanhuong_bt25th7;

public class NguyenVanHuong_Phone {
    private String ten;
    private String sdt;

    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public NguyenVanHuong_Phone(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }
}
