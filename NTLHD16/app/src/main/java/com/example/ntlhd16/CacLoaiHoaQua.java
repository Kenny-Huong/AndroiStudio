package com.example.ntlhd16;

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

public class CacLoaiHoaQua extends AppCompatActivity {
    private String selectedFruit = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cac_loai_hoa_qua);
        ListView listViewFruits = findViewById(R.id.listViewFruits);
        Button buttonNext = findViewById(R.id.buttonNext);

        final String[] fruits = {"Tao", "Le", "Mo", "Man", "Dao"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, fruits);
        listViewFruits.setAdapter(adapter);

        listViewFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedFruit = fruits[position];
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị thông báo khi nhấn nút NEXT
                Toast.makeText(CacLoaiHoaQua.this, "Bạn chọn: " + selectedFruit, Toast.LENGTH_SHORT).show();
            }
        });
    }
}