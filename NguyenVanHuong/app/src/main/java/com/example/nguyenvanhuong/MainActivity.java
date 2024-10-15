package com.example.nguyenvanhuong;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtTenCuaBan, edtTenDangNhap, edtMatKhau, edtStdOrEmail;
    Button btnDKTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtTenCuaBan=findViewById(R.id.edtTenCuaBan);
        edtTenDangNhap=findViewById(R.id.edtTenDangNhap);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        edtStdOrEmail=findViewById(R.id.edtSdtOrEmail);
        btnDKTK=findViewById(R.id.btnDKTK);

        btnDKTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenCuaBan = edtTenCuaBan.getText().toString();
                String tenDangNhap = edtTenDangNhap.getText().toString();
                String matKhau = edtMatKhau.getText().toString();
                String sdtOrEmail = edtStdOrEmail.getText().toString();


               /* if (tenCuaBan.equals("") || tenDangNhap.equals("") || matKhau.equals("") || sdtOrEmail.equals("")) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Đng ký thành công: " + "Họ Tên: " + tenCuaBan + "Tên Đăng Nhập: " + tenDangNhap + "Mật khẩu: " + matKhau + "Thông tin liên hệ: " + sdtOrEmail, Toast.LENGTH_SHORT).show();
                }*/

                List<String> missingFields = new ArrayList<>();
                if(tenCuaBan.equals("")){
                    missingFields.add("Họ tên");
                }
                if(tenDangNhap.equals("")){
                    missingFields.add("Tên Đăng Nhập");
                }
                if(matKhau.equals("")){
                    missingFields.add("Mật khẩu");
                }
                if(sdtOrEmail.equals("")){
                    missingFields.add("Thông Tin LH");
                }

                if(!missingFields.isEmpty()){
                    String message = "Bạn chưa nhập đủ thông tin : " + String.join(",",missingFields);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);

                    Bundle mybundle = new Bundle();
                    mybundle.putString("ten",tenCuaBan);
                    mybundle.putString("tenDN",tenDangNhap);
                    mybundle.putString("matkhau", matKhau);
                    mybundle.putString("SDT", sdtOrEmail);
                    intent.putExtra("dangky",mybundle);;

                    startActivity(intent);
                }
            }
        });
    }
}