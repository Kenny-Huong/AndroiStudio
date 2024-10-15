package com.example.nguyenvanhuong_bt21th7;

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

public class CoSoKyTucXa extends AppCompatActivity {
ListView lv;
    ArrayList <String> ds;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_co_so_ky_tuc_xa);

        lv=findViewById(R.id.lv);
        ds=new ArrayList<>();
        ds.add("Lĩnh Nam");
        ds.add("Minh Khai");
        ds.add("Nam Định");
        ds.add("Mỹ Xá");

        adapter = new ArrayAdapter<>(CoSoKyTucXa.this, android.R.layout.simple_list_item_1, ds);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CoSoKyTucXa.this, "Bạn chọn cơ sở : "+ds.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}