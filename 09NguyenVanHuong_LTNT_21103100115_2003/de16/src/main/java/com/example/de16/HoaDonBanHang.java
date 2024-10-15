package com.example.de16;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.badge.BadgeUtils;

public class HoaDonBanHang extends AppCompatActivity {
    EditText edtHoTen, edtCS1, edtCS2, edtThanhTien;
    CheckBox cbVAT;
    Button btnTinhTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hoa_don_ban_hang);

        edtCS1=findViewById(R.id.edtCS1);
        edtCS2=findViewById(R.id.edtCS2);
        edtHoTen=findViewById(R.id.edtHoTen);
        edtThanhTien=findViewById(R.id.edtThanhTien);
        cbVAT=findViewById(R.id.cbVAT);
        btnTinhTien=findViewById(R.id.btnTinhTien);

        btnTinhTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtCS1.getText().toString());
                int b = Integer.parseInt(edtCS2.getText().toString());
                if(cbVAT.isChecked()){
                    float d = (b-a)*2500+(b-a)*2500*1/10;
                    edtThanhTien.setText(d+"");
                }else{
                    float d = ((b-a)*2500);
                    edtThanhTien.setText(d+"");
                }
            }
        });
    }
}