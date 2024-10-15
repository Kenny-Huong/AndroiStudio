package com.example.baitap8_7;

public class Person {
    private int STT;
    private String mausac;
    private String sdt;
    private  String hoten;

    public Person() {
    }

    public Person(String hoten, String sdt, String mausac, int STT) {
        this.hoten = hoten;
        this.sdt = sdt;
        this.mausac = mausac;
        this.STT = STT;
    }

    public Person( String hoten, String sdt) {
        this.sdt = sdt;
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMausac() {
        return mausac;
    }
    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }
}
