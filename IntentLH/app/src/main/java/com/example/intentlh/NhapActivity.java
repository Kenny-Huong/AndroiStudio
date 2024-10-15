package com.example.intentlh;

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

public class NhapActivity extends AppCompatActivity {
    EditText editTextA,editTextB;
    Button buttonOK, buttonCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonOK = findViewById(R.id.buttonOK);
        buttonCancel = findViewById(R.id.buttonCancel);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OkRusult();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CancelResult();
            }
        });
    }
    private void OkRusult()
    {
        try{
            int a = Integer.parseInt(editTextA.getText().toString());
            int b = Integer.parseInt(editTextB.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("a",a+"");
            intent.putExtra("b",b+"");
            setResult(RESULT_OK,intent);
            finish();
        }
        catch(Exception e)
        {
            Toast.makeText(this, "Nhâ dữ liệu không đúng", Toast.LENGTH_SHORT).show();
        }
    }
    private void CancelResult()
    {
        setResult(RESULT_CANCELED);
        finish();
    }
}