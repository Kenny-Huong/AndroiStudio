package com.example.myapplication9th7;

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

public class HotenActivity extends AppCompatActivity {
    Button btnCallMain;
    Button btnSMSMain;
    Button btnWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoten);

        btnCallMain=findViewById(R.id.btnCallMain);
        btnSMSMain=findViewById(R.id.btnSMSMain);
        btnWeb=findViewById(R.id.btnWeb);

        btnCallMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotenActivity.this, CallActivity.class);
                startActivity(intent);
            }
        });

        btnSMSMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotenActivity.this,SMSActivity.class);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotenActivity.this,WebActivity.class);
                startActivity(intent);
            }
        });
    }
}