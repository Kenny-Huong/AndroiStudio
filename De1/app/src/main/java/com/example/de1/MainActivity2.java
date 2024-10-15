package com.example.de1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    RadioGroup rdgPhong;
    CheckBox cbBaiDoXe, cbWifi;
    Button btnChon, btnThoat1, btnTiep;
    RadioButton radioButton1, radioButton2, radioButton3 ,radioButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rdgPhong=findViewById(R.id.rdgPhong);
        cbBaiDoXe=findViewById(R.id.cbBaiDoXe);
        cbWifi=findViewById(R.id.cbWifi);
        btnChon=findViewById(R.id.btnChon);
        btnTiep=findViewById(R.id.btnTiep);
        btnThoat1=findViewById(R.id.btnThoat1);
        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        radioButton3=findViewById(R.id.radioButton3);
        radioButton4=findViewById(R.id.radioButton4);

        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chonphong = "";
                if(radioButton1.isChecked()){
                    chonphong +="Bạn đã chọn phòng " + radioButton1.getText().toString();
                } else if (radioButton2.isChecked()) {
                    chonphong += "Bạn đã chọn phòng " + radioButton2.getText().toString();
                } else if (radioButton3.isChecked()) {
                    chonphong += "Bạn đã chọn phòng " + radioButton3.getText().toString();
                } else if (radioButton4.isChecked()) {
                    chonphong += "Bạn đã chọn phòng " + radioButton4.getText().toString();
                }

                String chondv = "";
                if(cbBaiDoXe.isChecked()){
                    chondv += "," + cbBaiDoXe.getText().toString();
                }
                if (cbWifi.isChecked()) {
                    chondv += "," + cbWifi.getText().toString();
                }

                Toast.makeText(MainActivity2.this, chonphong +""+chondv, Toast.LENGTH_SHORT).show();
            }
        });
    }
}