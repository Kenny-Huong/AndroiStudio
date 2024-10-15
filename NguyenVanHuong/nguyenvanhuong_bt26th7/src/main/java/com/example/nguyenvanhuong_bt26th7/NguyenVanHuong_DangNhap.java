package com.example.nguyenvanhuong_bt26th7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NguyenVanHuong_DangNhap extends AppCompatActivity {
    EditText edtTenDangNhap, edtMatKhau;
    Button btnDangNhap, btnThoat;

    private static final String VALID_TaiKhoan = "DHTI15";
    private static final String VALID_MatKhau = "123456";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_dang_nhap);
        edtTenDangNhap=findViewById(R.id.edtTenDangNhap);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnThoat=findViewById(R.id.btnThoat);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taiKhoan = edtTenDangNhap.getText().toString();
                String matKhau = edtMatKhau.getText().toString();
                if(VALID_TaiKhoan.equals(taiKhoan) && VALID_MatKhau.equals(matKhau)){
                    Toast.makeText(NguyenVanHuong_DangNhap.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NguyenVanHuong_DangNhap.this, NguyenVanHuong_BaiHat.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NguyenVanHuong_DangNhap.this, "Tên Đăng Nhập Hoặc Mật Khẩu Không Đúng ! Nhập Lại ", Toast.LENGTH_SHORT).show();
                    edtTenDangNhap.setText("");
                    edtMatKhau.setText("");
                }
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

    }
}