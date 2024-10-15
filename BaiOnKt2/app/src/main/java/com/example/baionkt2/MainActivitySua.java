package com.example.baionkt2;

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

public class MainActivitySua extends AppCompatActivity {
    private EditText editmsp, editloaisp, edittensp, editgiasp;
    private Button btnOK, btnCancle;
    AdapterProduct adpter;
    Product product = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_them);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editmsp = findViewById(R.id.editmsp);
        editloaisp = findViewById(R.id.editloaisp);
        edittensp = findViewById(R.id.edittensp);
        editgiasp = findViewById(R.id.editgiasp);
        btnOK = findViewById(R.id.btnOK);
        btnCancle = findViewById(R.id.btnCancle);

        Intent I = getIntent();
        product = (Product) I.getParcelableExtra("product");
        renderValue();
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = editmsp.getText().toString();
                String ten = edittensp.getText().toString();
                String loai = editloaisp.getText().toString();
                int gia = Integer.parseInt(editgiasp.getText().toString());
                Product p = new Product(ma, ten, loai, gia, R.drawable.image_icon);

                Intent I = new Intent();
                I.putExtra("prdn" , p);
                setResult(RESULT_OK, I);
                finish();
            }
        });
    }

    private void renderValue() {
        if(product != null){
            editmsp.setText(product.getMasp());
            editloaisp.setText(product.getLoaisp());
            edittensp.setText(product.getTensp());
            editgiasp.setText(String.valueOf(product.getGia()));
        }
    }
}