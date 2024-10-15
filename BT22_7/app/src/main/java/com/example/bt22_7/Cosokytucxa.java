package com.example.bt22_7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class Cosokytucxa extends AppCompatActivity {

    private Button btnNextto,buttonTrolai;
    private ListView lv1;
    ArrayList<String> ktx = new ArrayList<>(Arrays.asList("Linh Nam", "Minh Khai", "Nam Dinh", "My Xa"));
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosokytucxa);

        lv1 = findViewById(R.id.lv1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ktx);
        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) 
            {
                Toast.makeText(Cosokytucxa.this, "Thành công", Toast.LENGTH_SHORT).show();
            }
        });


        btnNextto = findViewById(R.id.btnNextto);
        btnNextto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                 Intent I = new Intent(Cosokytucxa.this, Json.class);
                startActivity(I);
            }
        });

        buttonTrolai = findViewById(R.id.buttonTrolai);
        buttonTrolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(Cosokytucxa.this, DangKy.class);
                startActivity(I);
            }
        });


    }
}