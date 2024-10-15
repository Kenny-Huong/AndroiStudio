package com.example.intentlh;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class PhoneActivity extends AppCompatActivity {
    EditText editTextSDT;
    Button buttonCall,buttonDial;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        editTextSDT = findViewById(R.id.editTextSDT);
        buttonCall = findViewById(R.id.buttonCall);
        buttonDial = findViewById(R.id.buttonDial);

        buttonDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneDial();
            }
        });
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneCall();
            }
        });
    }
    private void PhoneDial(String sdt)
    {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel"+sdt));
        startActivity(intent);
    }
    private void PhoneCall(String sdt)
    {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel"+sdt));
        if(ContextCompat.checkSelfPermission(this,CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
        {
            startActivity(intent);
        }
        else {
            requestPermissions(new String[CALL_PHONE],1);
        }
    }

}