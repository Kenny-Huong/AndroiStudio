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

public class MainActivity2 extends AppCompatActivity {
    TextView tvHI, tva, tvb, tvc;
    Button btnBack, btnTiep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        tvHI=findViewById(R.id.tvHI);
        tva=findViewById(R.id.tva);
        tvb=findViewById(R.id.tvb);
        tvc=findViewById(R.id.tvc);
        btnTiep = findViewById(R.id.btnTiep);
        btnBack = findViewById(R.id.btnBack);


        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("dangky");
        String HI = yourbundle.getString("ten");
        String a = yourbundle.getString("tenDN");
        String b = yourbundle.getString("matkhau");
        String c = yourbundle.getString("SDT");
        tvHI.setText("Chúc mừng bạn " +HI+ " đã đăng ký thành công!");
        tva.setText("Tên đăng nhập: "+a);
        tvb.setText("Mật khẩu: "+b);
        tvc.setText("Email hoặc số iện thoại đăng ký: "+c);


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}