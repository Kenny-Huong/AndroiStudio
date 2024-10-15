package com.example.de11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DanhSachBaiHat extends AppCompatActivity {
    ListView lv;
    EditText edtTen, edtCaSi;
    ArrayList <BaiHat> arrayList;
    ArrayAdapter <BaiHat> adapter;
    int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_bai_hat);
        lv=findViewById(R.id.lv);
        edtTen=findViewById(R.id.edtTen);
        edtCaSi=findViewById(R.id.edtCaSi);

        arrayList = new ArrayList<>();
        arrayList.add(new BaiHat("Dom dom","Jack"));
        arrayList.add(new BaiHat("Thien Ly Oi","Trinh Tran Phuong Tuan"));
        arrayList.add(new BaiHat("Ve ben anh","J97"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    selectedIndex = i;
                    String ten = edtTen.getText().toString();
                    String casi = edtCaSi.getText().toString();

                Intent intent = new Intent(DanhSachBaiHat.this,CTBH.class);
                intent.putExtra("ten", arrayList.get(selectedIndex).getTen());
                intent.putExtra("casi", arrayList.get(selectedIndex).getCasi());
                startActivity(intent);
            }
        });
    }
}