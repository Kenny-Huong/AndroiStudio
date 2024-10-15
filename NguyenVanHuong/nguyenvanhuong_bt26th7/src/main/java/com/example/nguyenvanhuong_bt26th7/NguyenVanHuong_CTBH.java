package com.example.nguyenvanhuong_bt26th7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NguyenVanHuong_CTBH extends AppCompatActivity {
    TextView tvTen, tvTenCasi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_ctbh);
        tvTen=findViewById(R.id.tvTen);
        tvTenCasi=findViewById(R.id.tvTenCasi);

        String ten = getIntent().getStringExtra("Ten");
        String baihat = getIntent().getStringExtra("Baihat");

        tvTen.setText(ten);
        tvTenCasi.setText(baihat);
    }

}