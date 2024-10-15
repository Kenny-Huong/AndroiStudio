package com.example.ntlhd16;

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

public class KiemtrasntActivity extends AppCompatActivity {

    EditText edtN, edtKQ;
    Button btnKT, btnThoatKT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kiemtrasnt);
        edtN=findViewById(R.id.edtN);
        edtKQ=findViewById(R.id.edtKQ);
        btnKT=findViewById(R.id.btnKT);
        btnThoatKT=findViewById(R.id.btnThoatKT);

        btnKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strSo = edtN.getText().toString();
                if(strSo.isEmpty()){
                    edtKQ.setText("Vui lòng nhập lại số cần kiểm tra !!");
                    return;
                }
                int so = Integer.parseInt(strSo);
                boolean isPrime = isPrime(so);
                String KetQua = isPrime ? so + " là số nguyên tố !" : so + " không phải là số nguyên tố !";
                edtKQ.setText(KetQua);
            }
        });

        btnThoatKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}