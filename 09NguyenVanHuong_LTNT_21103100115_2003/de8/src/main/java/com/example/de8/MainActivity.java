package com.example.de8;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList <DanhBa> arrayList;
    ArrayAdapter <DanhBa> adapter;
    ImageButton btnCall, btnSMS;
    int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lv=findViewById(R.id.lv);
        btnCall=findViewById(R.id.btnCall);
        btnSMS=findViewById(R.id.btnSMS);

        arrayList = new ArrayList<>();
        arrayList.add(new DanhBa("Nguyen Van A","1231231212"));
        arrayList.add(new DanhBa("Nguyen Trong B", "044445555"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex=i;
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DanhBa selectedItem = arrayList.get(selectedIndex);
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+selectedItem.getSdt()));
                startActivity(intent);
            }
        });

        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DanhBa selectedItem = arrayList.get(selectedIndex);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("sms:"+selectedItem.getSdt()));
                startActivity(intent);
            }
        });
    }
}