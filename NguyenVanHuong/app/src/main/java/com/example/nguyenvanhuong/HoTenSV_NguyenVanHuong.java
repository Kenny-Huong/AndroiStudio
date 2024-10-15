package com.example.nguyenvanhuong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HoTenSV_NguyenVanHuong extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5;
    Button btnTiep2, btnThoat2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ho_ten_sv_nguyen_van_huong);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        btnTiep2 = findViewById(R.id.btnTiep2);
        btnThoat2 = findViewById(R.id.btnThoat2);

        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("guithongtin");
        String ten = yourbundle.getString("ten");
        String a = yourbundle.getString("cmnd");
        String b = yourbundle.getString("bangcap");
        String c = yourbundle.getString("sothich");
        String d = yourbundle.getString("bosung");

        tv1.setText("Họ và tên người gửi là: "+ten);
        tv2.setText("Chứng minh nhân dân: "+a);
        tv3.setText("Bằng cấp: "+b);
        tv4.setText("Sở thích: "+c);
        tv5.setText("Thông tin bổ sung: "+d);
        btnThoat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}