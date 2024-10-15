package com.example.de11;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CTBH extends AppCompatActivity {
    TextView tvTenBaiHat, tvTenCaSi;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ctbh);

        tvTenBaiHat=findViewById(R.id.tvTenBaiHat);
        tvTenCaSi=findViewById(R.id.tvTenCaSi);

        String tenbh = getIntent().getStringExtra("ten");
        String tencs = getIntent().getStringExtra("casi");

        tvTenCaSi.setText(tenbh);
        tvTenBaiHat.setText(tencs);
    }
}