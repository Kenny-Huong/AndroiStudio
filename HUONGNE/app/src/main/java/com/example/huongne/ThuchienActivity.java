package com.example.huongne;

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

public class ThuchienActivity extends AppCompatActivity {

    private EditText editTextA,editTextB,editTextKQ;
    private Button buttonTIM,buttonTHOAT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuchien);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextKQ = findViewById(R.id.editTextKQ);
        buttonTIM = findViewById(R.id.buttonTIM);
        buttonTHOAT = findViewById(R.id.buttonTHOAT);

        buttonTIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strA = editTextA.getText().toString();
                String strB = editTextB.getText().toString();

                if (strA.isEmpty() || strB.isEmpty()) {
                    editTextKQ.setText("Vui lòng nhập đầy đủ hai số a và b.");
                    return;
                }

                int a = Integer.parseInt(strA);
                int b = Integer.parseInt(strB);

                int gcd = findGCD(a, b);
                editTextKQ.setText(" "+ gcd);
            }
        });

        buttonTHOAT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThuchienActivity.this,LuachonActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}