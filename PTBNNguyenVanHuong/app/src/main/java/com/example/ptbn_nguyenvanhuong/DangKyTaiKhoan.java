package com.example.ptbn_nguyenvanhuong;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DangKyTaiKhoan extends AppCompatActivity {
    EditText edtTenCuaBan, edtTenDangNhap, edtMatKhau, edtStdOrEmail;
    Button btnDKTK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dang_ky_tai_khoan);
        edtTenCuaBan=findViewById(R.id.edtTenCuaBan);
        edtTenDangNhap=findViewById(R.id.edtTenDangNhap);
        edtMatKhau=findViewById(R.id.edtMatKhau);
        edtStdOrEmail=findViewById(R.id.edtSdtOrEmail);
        btnDKTK=findViewById(R.id.btnDKTK);

        btnDKTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenCuaBan = edtTenCuaBan.getText().toString().trim();
                String tenDangNhap = edtTenDangNhap.getText().toString().trim();
                String matKhau = edtMatKhau.getText().toString().trim();
                String sdtOrEmail = edtStdOrEmail.getText().toString().trim();


                if (tenCuaBan.equals("") || tenDangNhap.equals("") || matKhau.equals("") || sdtOrEmail.equals("")) {
                    Toast.makeText(DangKyTaiKhoan.this, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DangKyTaiKhoan.this, "Đng ký thành công: " + "Họ Tên: " + tenCuaBan + "Tên Đăng Nhập: " + tenDangNhap + "Mật khẩu: " + matKhau + "Thông tin liên hệ: " + sdtOrEmail, Toast.LENGTH_SHORT).show();
                }
                AlertDialog.Builder dialog = new AlertDialog.Builder(DangKyTaiKhoan.this);



            }
        });
    }
}
/*
String ten = edtTen.getText().toString();
                Toast.makeText(HienThiThongBao.this, "Tên vừa nhập là"+ten, Toast.LENGTH_SHORT).show();
//Tạo Diolodg
AlertDialog.Builder dialog = new AlertDialog.Builder(HienThiThongBao.this);
//Tạo tiêu đề cho dialog
                dialog.setTitle("Thông tin sinh viên");
//Hiển thị nội dung của dialog
                dialog.setMessage("Tên sinh viên : "+ten);
//Tạo nút đóng
                dialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
});
        //Hiển thị dialog
        dialog.show();*/
