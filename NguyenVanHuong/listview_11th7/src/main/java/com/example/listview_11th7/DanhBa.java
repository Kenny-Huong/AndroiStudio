package com.example.listview_11th7;

public class DanhBa {
    private String hoten, sdt;

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
        return  hoten + '\n' + sdt;
    }
}
