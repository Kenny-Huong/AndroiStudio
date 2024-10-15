package com.example.ptbn_nguyenvanhuong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnGiai, btnTiep, btnThoat;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtA=findViewById(R.id.edtA);
        edtB=findViewById(R.id.edtB);
        edtKQ=findViewById(R.id.edtKQ);
        btnGiai=findViewById(R.id.btnGiai);
        btnTiep=findViewById(R.id.btnTiep);
        btnThoat=findViewById(R.id.btnThoat);


        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float a = Float.parseFloat(edtA.getText().toString());
                float b = Float.parseFloat(edtB.getText().toString());
                double KQ = (-b)/a;
                if(a == 0){
                    if(b == 0){
                        edtKQ.setText("Phương trình có vô số nghiệm!");
                    }else{
                        edtKQ.setText("Phương trình vô nghiệm!");
                    }
                }else{
                    edtKQ.setText("x = " + KQ);
                }
            }

        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}