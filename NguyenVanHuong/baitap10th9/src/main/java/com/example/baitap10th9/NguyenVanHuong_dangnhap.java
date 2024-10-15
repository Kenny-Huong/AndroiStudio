package com.example.baitap10th9;

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

public class NguyenVanHuong_dangnhap extends AppCompatActivity {
    EditText edtDangNhap, edtMatKhau;
    Button btnDangNhap, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_dangnhap);

        edtDangNhap=findViewById(R.id.edtDangNhap);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnThoat=findViewById(R.id.btnThoat);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dangnhap = edtDangNhap.getText().toString();
                String matkhau = edtMatKhau.getText().toString();
                if(dangnhap.equals("cnttk15")&&matkhau.equals("123456")){
                    Intent intent = new Intent(NguyenVanHuong_dangnhap.this,JsonActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("a",dangnhap);
                    bundle.putString("b",matkhau);
                    intent.putExtra("goihang",bundle);
                    startActivity(intent);

                    Intent intent1 = new Intent(NguyenVanHuong_dangnhap.this,HuongActivity.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(NguyenVanHuong_dangnhap.this, "Vui Long Nhap Lai !!!", Toast.LENGTH_SHORT).show();
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