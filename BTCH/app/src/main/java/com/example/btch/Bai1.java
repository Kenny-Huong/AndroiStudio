package com.example.btch;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Bai1 extends AppCompatActivity {

    EditText soA, soB, ketqua;
    Button btnCong, btnTru, btnNhan, btnChia;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        //tham chieu
        InitObject();
        // Thiết lập sự kiện cho nút cộng
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulypheptinh("+");
            }
        });
        //Thiết lập sự kiện cho nút trừ
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulypheptinh("-");
            }
        });
        //Thiết lập sự kiện cho nút nhân
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulypheptinh("*");
            }
        });
        //Thiết lập sự kiện cho nút chia
        btnChia.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulypheptinh("/");
            }
        }));
    }

    private void xulypheptinh(String s)
    {
        try {
            int a = Integer.parseInt(soA.getText().toString());
            int b = Integer.parseInt(soB.getText().toString());
            switch (s){
                case "+":
                    ketqua.setText(""+(a+b));
                    break;
                case "-":
                    ketqua.setText(""+(a-b));
                    break;
                case "*":
                    ketqua.setText(""+(a*b));
                    break;
                case "/":
                    if (b!=0) {
                        ketqua.setText("" + ((float) a / b));
                    }
                    else {
                        Toast.makeText(this, "Số B phải khác 0!", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }catch (Exception e){
            Toast.makeText(this, "Lỗi nhập dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }

    private void InitObject()
    {
        soA = findViewById(R.id.soA);
        soB = findViewById(R.id.soB);
        ketqua = findViewById(R.id.ketQua);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }

}