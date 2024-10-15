package com.example.danhsachdienthoai;

public class Phone {
    private int hinh;
    private String ten;

    public Phone(int hinh, String ten) {
        this.hinh = hinh;
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    //CustomList View không xây dựng hàm ToString nhaaaaa
}
