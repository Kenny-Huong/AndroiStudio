package com.example.ntlhd16;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChonActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button btnChon,btnThoat, btnKTSNT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chon);

        btnChon = findViewById(R.id.btnChon);
        btnThoat = findViewById(R.id.btnThoat);
        btnKTSNT = findViewById(R.id.btnKTSNT);


        btnKTSNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnChon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ChonActivity.this, KiemtrasntActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}