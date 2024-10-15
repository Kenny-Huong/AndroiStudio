package com.example.kt_17_7;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Product implements Parcelable {
    private String masp;
    private String tensp;
    private String loaisp;
    private int gia;
    private int img;

    public Product(String masp, String tensp, String loaisp, int gia, int img) {
        this.tensp = tensp;
        this.masp = masp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.img = img;
    }

    public Product(String masp, String tensp, String loaisp, int gia) {
        this.tensp = tensp;
        this.masp = masp;
        this.loaisp = loaisp;
        this.gia = gia;
    }

    public Product() {
    }

    protected Product(Parcel in) {
        masp = in.readString();
        tensp = in.readString();
        loaisp = in.readString();
        gia = in.readInt();
        img = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Product{" +
                "masp='" + masp + '\'' +
                ", tensp='" + tensp + '\'' +
                ", loaisp='" + loaisp + '\'' +
                ", gia=" + gia +
                ", img=" + img +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(masp);
        parcel.writeString(tensp);
        parcel.writeString(loaisp);
        parcel.writeInt(gia);
        parcel.writeInt(img);
    }
}
