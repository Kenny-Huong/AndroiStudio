package com.example.nguyenvanhuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai3_YeuCauKetQua_4_7 extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnYCKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai3_yeu_cau_ket_qua47);
        edtA=findViewById(R.id.edtA);
        edtB=findViewById(R.id.edtB);
        edtKQ=findViewById(R.id.edtKQ);
        btnYCKQ=findViewById(R.id.btnYCKQ);

        btnYCKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent =new Intent(Bai3_YeuCauKetQua_4_7.this, Bai3_XuLyKetQua_4_7.class);
                startActivity(myintent);

                //Lấy dữ liêụ a và b
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());

                //Tạo bundle để chứa dữ lệu gửi đi
                Bundle mybundle = new Bundle();

                //Đưa dữ liệu vào bundle
                mybundle.putInt("soa", a);
                mybundle.putInt("sob", b);

                //Đẩy dữ liệu vào intent
                myintent.putExtra("mybackage", mybundle);
                startActivity(myintent);
            }
        });

    }

}