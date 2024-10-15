package com.example.intentlh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView soA,soB,Tong;
    Button btnNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soA = findViewById(R.id.soA);
        soB = findViewById(R.id.soB);
        Tong = findViewById(R.id.Tong);
        btnNhap = findViewById(R.id.btnNhap);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallNhap();
            }
        });
    }
    private void CallNhap()
    {
        Intent intent = new Intent(MainActivity.this, NhapActivity.class);
        startActivityForResult(intent,1001);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == 1001) {
            if (resultCode == RESULT_OK) {
                int a = Integer.parseInt(data.getStringExtra("a"));
                int b = Integer.parseInt(data.getStringExtra("b"));
                soA.setText("Số a: " + a);
                soB.setText("Số b: " + b);
                Tong.setText("Tổng của 2 số: " + (a + b));
            }
        }else {
            soA.setText("Số a: ");
            soB.setText("Số b: ");
            Tong.setText("Tổng của 2 số: ");
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}