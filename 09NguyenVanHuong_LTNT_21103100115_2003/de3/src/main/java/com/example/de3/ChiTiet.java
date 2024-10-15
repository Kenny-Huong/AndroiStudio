package com.example.de3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChiTiet extends AppCompatActivity {

    TextView tvTen, tvsdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chi_tiet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvTen=findViewById(R.id.tvTen);
        tvsdt=findViewById(R.id.tvsdt);

        //Lấy dữ liệu từ Intent
        String ten = getIntent().getStringExtra("ten");
        String sdt = getIntent().getStringExtra("sdt");

        //Gán lên textview
        tvsdt.setText(sdt);
        tvTen.setText(ten);

    }
}