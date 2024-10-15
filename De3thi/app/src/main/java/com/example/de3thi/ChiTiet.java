package com.example.de3thi;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChiTiet extends AppCompatActivity {

    private TextView textViewTen,textViewSĐT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);

        textViewTen = findViewById(R.id.textViewTen);
        textViewSĐT = findViewById(R.id.textViewSĐT);

        // Lấy dữ liệu từ Intent
        String hoten = getIntent().getStringExtra("hoten");
        String sdt = getIntent().getStringExtra("sdt");

        // Hiển thị dữ liệu
        textViewTen.setText("Họ tên: " + hoten);
        textViewSĐT.setText("Số điện thoại: " + sdt);

    }
}