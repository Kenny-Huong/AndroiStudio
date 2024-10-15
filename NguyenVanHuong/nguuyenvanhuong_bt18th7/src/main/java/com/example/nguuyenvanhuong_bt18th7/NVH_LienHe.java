package com.example.nguuyenvanhuong_bt18th7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NVH_LienHe extends AppCompatActivity {
    TextView tvHoTen;
    TextView tvSDT;
    ImageButton btnThoat;
    ImageButton btnSMS;
    ImageButton btnCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nvh_lien_he);
        tvHoTen=findViewById(R.id.tvHoTen);
        tvSDT=findViewById(R.id.tvSDT);
        btnThoat=findViewById(R.id.btnThoat);
        btnCall=findViewById(R.id.btnCall);
        btnSMS=findViewById(R.id.btnSMS);

        String hoTen = getIntent().getStringExtra("ten");
        String sdt = getIntent().getStringExtra("sdt");

        tvHoTen.setText(hoTen);
        tvSDT.setText(sdt);
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + sdt));
                startActivity(callIntent);
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("sms:" + sdt));
                startActivity(smsIntent);
            }
        });
    }
}