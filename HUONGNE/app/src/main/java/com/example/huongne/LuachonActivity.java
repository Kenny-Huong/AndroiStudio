package com.example.huongne;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LuachonActivity extends AppCompatActivity {

    private RadioGroup radioGroupLC;
    private RadioButton radioButtonPheptinh,radioButtonUSCLN,radioButtonTimgtN;
    private Button buttonCHON,buttonTHOAT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luachon);

        radioGroupLC = findViewById(R.id.radioGroupLC);
        radioButtonPheptinh = findViewById(R.id.radioButtonPheptinh);
        radioButtonUSCLN = findViewById(R.id.radioButtonUSCLN);
        radioButtonTimgtN = findViewById(R.id.radioButtonTimgtN);
        buttonCHON = findViewById(R.id.buttonCHON);
        buttonTHOAT = findViewById(R.id.buttonTHOAT);

        buttonCHON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int luachon = radioGroupLC.getCheckedRadioButtonId();
                if(luachon == -1)
                {
                    Toast.makeText(LuachonActivity.this, "Vui lòng chọn 1 lựa chọn", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(LuachonActivity.this,ThuchienActivity.class);
                    startActivity(intent);
                }
            }
        });

        buttonTHOAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LuachonActivity.this,DangnhapActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}