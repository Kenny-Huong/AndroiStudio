package com.example.myapplicationtinhtong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       edtA=findViewById(R.id.edtA);
       edtB=findViewById(R.id.edtB);
       btnKQ=findViewById(R.id.btnKQ);

       btnKQ.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //Lấy dữ liệu được nhập vào từ các EditText
               int a = Integer.parseInt(edtA.getText().toString());
               int b = Integer.parseInt(edtB.getText().toString());

               //Khai báo Intent
               Intent myintent = new Intent(MainActivity.this, MainActivity2.class);

               //Tạo Bundle để chứa dữ liệu gửi đi
               Bundle mybundle = new Bundle();

               //Đưa dữ liệu vào Bundle
               mybundle.putInt("soa", a);
               mybundle.putInt("sob", b);

               //Đẩy dữ liệu vào Intent
               myintent.putExtra("mybackage", mybundle);
               startActivity(myintent);
           }
       });
    }
}