package com.example.nguyenvanhuong_bt19th7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NguyenVanHuong_CTSP extends AppCompatActivity {
    EditText edtTenSP, edtMaSP, edtGiaSP;
    private Button btnDelete;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_ctsp);
        edtMaSP=findViewById(R.id.edtMaSP);
        edtTenSP=findViewById(R.id.edtTenSP);
        edtGiaSP=findViewById(R.id.edtGiaSP);
        btnDelete = findViewById(R.id.btnDelete);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        edtMaSP.setText("Mã sản phẩm: " + intent.getStringExtra("productCode"));
        edtTenSP.setText("Tên sản phẩm: " + intent.getStringExtra("productName"));
        edtGiaSP.setText("Đơn giá bán: " + intent.getStringExtra("productPrice"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}