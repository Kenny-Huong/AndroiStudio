package com.example.nguyenvanhuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai3_XuLyKetQua_4_7 extends AppCompatActivity {
    EditText edtAA, edtBB;
    Button btnsendtong, btnsendhieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3_xu_ly_ket_qua47);

        edtAA = findViewById(R.id.edtAA);
        edtBB = findViewById(R.id.edtBB);
        btnsendtong=findViewById(R.id.btnsendtong);
        btnsendhieu=findViewById(R.id.btnsendhieu);

        //Nhận Intent
        Intent intent = getIntent();
        //Lây dữ liệu khỏi intent
        int a = intent.getIntExtra("soa", 0);
        int b = intent.getIntExtra("sob", 0);
        edtAA.setText(a + "");
        edtBB.setText(b + "");
        btnsendtong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = a + b;

            }
        });

    }
}