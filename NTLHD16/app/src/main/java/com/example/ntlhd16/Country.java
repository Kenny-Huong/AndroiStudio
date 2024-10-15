package com.example.ntlhd16;

public class Country {
    private String tennuoc;
    private String mota;
    private int hinh;

    public Country(String tennuoc, String mota, int hinh) {
        this.tennuoc = tennuoc;
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getTennuoc() {
        return tennuoc;
    }

    public void setTennuoc(String tennuoc) {
        this.tennuoc = tennuoc;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
