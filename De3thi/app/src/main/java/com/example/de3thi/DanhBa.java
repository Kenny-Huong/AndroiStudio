package com.example.de3thi;

public class    DanhBa
{
    private String hoten;
    private String sdt;

    public DanhBa(String hoten, String sdt) {
        this.hoten = hoten;
        this.sdt = sdt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return hoten;
    }
    public String Chitiet()
    {
        return "Họ tên: " + hoten + "\nSố điện thoại: " + sdt ;
    }
}
