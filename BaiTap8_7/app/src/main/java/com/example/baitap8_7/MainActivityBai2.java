package com.example.baitap8_7;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityBai2 extends AppCompatActivity {
    ListView ListFruist;
    ArrayList<String> Fruist  = new ArrayList<>(Arrays.asList("Tao", "Le", "Mo", "Man", "Dao"));
    ArrayAdapter<String> adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bai2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ListFruist = findViewById(R.id.ListFruist);

        adapter2 = new ArrayAdapter<>(MainActivityBai2.this, android.R.layout.simple_list_item_1, Fruist);
        ListFruist.setAdapter(adapter2);

        ListFruist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivityBai2.this, "Bạn chọn: " + Fruist.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}