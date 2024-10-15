package com.example.nguyenvanhuong_menu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class hoa_don extends AppCompatActivity {

    CheckBox checkBox;
    EditText edtHoten, edtTruoc, edtSau, edtTT;
    Button btnTT, btnThoat, btnTinhLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoa_don);
        edtHoten = findViewById(R.id.edtHoten);
        edtTruoc = findViewById(R.id.edtTruoc);
        edtSau = findViewById(R.id.edtSau);
        edtTT = findViewById(R.id.edtTT);
        btnTT = findViewById(R.id.btnTT);
        btnThoat = findViewById(R.id.btnThoat);
        checkBox = findViewById(R.id.checkbox);
        btnTinhLai = findViewById(R.id.btnTinhLai);
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int previousReading = Integer.parseInt(edtTruoc.getText().toString());
                int currentReading = Integer.parseInt(edtSau.getText().toString());

                float totalAmount = (currentReading - previousReading) * 2500;


                if (checkBox.isChecked()) {
                    totalAmount += totalAmount * 0.1; // Applying 10% VAT
                }

                edtTT.setText(String.format("%,.0f", totalAmount));
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