package com.example.ptbn_nguyenvanhuong;

import android.content.DialogInterface;
import android.os.Bundle;
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

public class HienThiThongBao extends AppCompatActivity {
    EditText edtTen;
    Button btnNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hien_thi_thong_bao);
        edtTen=findViewById(R.id.edtTen);
        btnNhap=findViewById(R.id.btnNhap);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                dialog.show();
            }
        });

    }
}