package com.example.intent_nguyenvanhuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//Khai báo biến giao diện
    Button btnCha, btnCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Ánh Xạ
        btnCha=findViewById(R.id.btnCha);
        //Xử lý sự kiện kích chuột vào nút Button
        btnCha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Khai Báo Intent
                Intent kennyintent=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(kennyintent);
            }
        });
    }
}