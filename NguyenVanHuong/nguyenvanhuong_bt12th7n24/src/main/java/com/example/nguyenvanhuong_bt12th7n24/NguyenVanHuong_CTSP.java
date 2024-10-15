package com.example.nguyenvanhuong_bt12th7n24;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NguyenVanHuong_CTSP extends AppCompatActivity {
    private TextView productCode;
    private TextView productName;
    private TextView productPrice;
    private Button btnDelete;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_ctsp);
        productCode = findViewById(R.id.productCode);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        btnDelete = findViewById(R.id.btnDelete);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        productCode.setText("Mã sản phẩm: " + intent.getStringExtra("productCode"));
        productName.setText("Tên sản phẩm: " + intent.getStringExtra("productName"));
        productPrice.setText("Đơn giá bán: " + intent.getStringExtra("productPrice"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}