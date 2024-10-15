package com.example.ntlhd16;

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

public class DangnhapActivity extends AppCompatActivity {

    private Button buttonDN;
    private EditText editTextEmail,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonDN = findViewById(R.id.buttonDN);
        buttonDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.equals("Admin@gmail.com") && password.equals("Admin")) {
                    Intent intent = new Intent(DangnhapActivity.this,ChonActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(DangnhapActivity.this, "Tài khoản không đúng", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}