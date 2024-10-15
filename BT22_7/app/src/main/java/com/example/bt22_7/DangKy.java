package com.example.bt22_7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKy extends AppCompatActivity {

    private RadioButton radioButton1,radioButton2,radioButton3,radioButton4;
    private Button btnChoose,btnExit,btnNext;
    private CheckBox cbBaidoxe,cbWifi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);
        btnChoose = findViewById(R.id.btnChoose);
        btnExit = findViewById(R.id.btnExit);
        btnNext = findViewById(R.id.btnNext);
        cbBaidoxe = findViewById(R.id.cbBaidoxe);
        cbWifi = findViewById(R.id.cbWifi);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chonphong = "";
                if(radioButton1.isChecked())
                {
                    chonphong += "Bạn đã chọn phòng: "+radioButton1.getText().toString();
                } else if (radioButton2.isChecked())
                {
                    chonphong += "Bạn đã chọn phòng: "+radioButton2.getText().toString();
                } else if (radioButton3.isChecked())
                {
                    chonphong += "Bạn đã chọn phòng: "+radioButton3.getText().toString();
                } else if (radioButton4.isChecked())
                {
                    chonphong += "Bạn đã chọn phòng: "+radioButton4.getText().toString();
                }
                String chondv = "";
                if(cbBaidoxe.isChecked())
                {
                    chondv += ", "+cbBaidoxe.getText().toString();
                }
                if (cbWifi.isChecked())
                {
                    chondv += ", "+cbWifi.getText().toString();
                }
                Toast.makeText(DangKy.this, chonphong +" "+ chondv, Toast.LENGTH_SHORT).show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, Cosokytucxa.class);
                startActivity(intent);
            }
        });
    }
}