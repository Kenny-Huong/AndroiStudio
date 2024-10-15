package com.example.baitap10th9;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SMSActivity extends AppCompatActivity {
    EditText edtSMS;
    ImageButton btnSMS;
    Button btnBackSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_smsactivity);

        edtSMS=findViewById(R.id.edtSMS);
        btnSMS=findViewById(R.id.btnSMS);
        btnBackSMS=findViewById(R.id.btnBackSMS);

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtSMS.getText().toString()));
                startActivity(intent);
            }
        });
        btnBackSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}