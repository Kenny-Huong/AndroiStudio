package com.example.de13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtTK, edtMK;
    Button btnDangNhap, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtTK=findViewById(R.id.edtTK);
        edtMK=findViewById(R.id.edtMK);
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnThoat=findViewById(R.id.btnThoat);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTK.getText().toString();
                String mk = edtMK.getText().toString();
                if(ten.equalsIgnoreCase("candy")&&mk.equalsIgnoreCase("123")){
                    Intent intent = new Intent(MainActivity.this, DanhSachSP.class);
                    Toast.makeText(MainActivity.this, "Login Successful !", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Errol!!!", Toast.LENGTH_SHORT).show();
                    edtTK.setText("");
                    edtMK.setText("");
                }
            }
        });

    }
}