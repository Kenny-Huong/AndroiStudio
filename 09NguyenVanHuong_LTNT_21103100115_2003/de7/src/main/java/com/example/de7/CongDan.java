package com.example.de7;

public class CongDan {
    private String hoTen;
    private String CCCD;

    public CongDan(String hoTen, String CCCD) {
        this.hoTen = hoTen;
        this.CCCD = CCCD;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    @Override
    public String toString() {
        return  hoTen  +"-"+ CCCD;
    }
}
