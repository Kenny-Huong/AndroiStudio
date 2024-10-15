package com.example.nguyenvanhuong_bt21th7;

import android.content.Intent;
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

public class DangKyKyTucXa extends AppCompatActivity {
    RadioGroup rdgPhong;
    CheckBox cbBaiDoXe, cbWifi;
    Button btnChon, btnThoat2, btnTiep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky_ky_tuc_xa);

        rdgPhong=findViewById(R.id.rdgPhong);
        cbBaiDoXe=findViewById(R.id.cbBaiDoXe);
        cbWifi=findViewById(R.id.cbWifi);
        btnChon=findViewById(R.id.btnChon);
        btnThoat2=findViewById(R.id.btnThoat2);
        btnTiep=findViewById(R.id.btnTiep);

        btnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedRoomTypeId = rdgPhong.getCheckedRadioButtonId();
                RadioButton selectedRoomType = findViewById(selectedRoomTypeId);
                boolean isParkingChecked = cbBaiDoXe.isChecked();
                boolean isWifiChecked = cbWifi.isChecked();

                String selectedServices = "Dịch vụ đã chọn: " + (isParkingChecked ? "Bãi đỗ xe, " : "") + (isWifiChecked ? "Wifi" : "");
                String selectedRoomTypeText = selectedRoomType != null ? selectedRoomType.getText().toString() : "Không chọn";


                Toast.makeText(DangKyKyTucXa.this, "Phòng: " + selectedRoomTypeText + "\n" + selectedServices, Toast.LENGTH_SHORT).show();
            }
        });

        btnThoat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKyKyTucXa.this, CoSoKyTucXa.class);
                startActivity(intent);
            }
        });
    }
}