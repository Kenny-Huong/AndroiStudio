package com.example.de10;

public class DanhSach {
    private String ten;
    private String casi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    public DanhSach(String ten, String casi) {
        this.ten = ten;
        this.casi = casi;
    }

    @Override
    public String toString() {
        return  ten +"-" +casi;
    }
}
