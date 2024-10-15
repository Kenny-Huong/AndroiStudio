package com.example.myapplicationtinhtong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    TextView tvkq;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        tvkq=findViewById(R.id.tvkq);
        btnBack=findViewById(R.id.btnBack);

        //Nhận Intent đuọc gửi từ Mainactivity
        Intent yourintent = getIntent();

        //Lấy bundle khoỏi Intent
        Bundle yourbundle = yourintent.getBundleExtra("mybackage");

        //Lấy dữ liệu ra khỏi Bundle
        assert yourbundle != null;
        int a = yourbundle.getInt("soa");
        int b = yourbundle.getInt("sob");

        //Tính tổng
        int sum = a + b;

        //Hiển thị tổng lên TextView
        tvkq.setText(sum+"");
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}