package com.example.baitap10th9;

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

public class JsonActivity extends AppCompatActivity {
    EditText edt1, edt2;
    Button btnThoat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json);
        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btnThoat1=findViewById(R.id.btnThoat1);

        Intent yourintent = getIntent();
        Bundle yourbundle = yourintent.getBundleExtra("goihang");
        String a = yourbundle.getString("a");
        String b = yourbundle.getString("b");

        edt1.setText(a);
        edt2.setText(b);

        btnThoat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}