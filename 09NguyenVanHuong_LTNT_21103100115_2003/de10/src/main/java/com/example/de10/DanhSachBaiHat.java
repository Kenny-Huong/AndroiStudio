package com.example.de10;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class DanhSachBaiHat extends AppCompatActivity {
    EditText edtTen, edtCaSi;
    Button btnThem;
    ListView lv;
    ArrayList <DanhSach> arrayList;
    ArrayAdapter <DanhSach> adapter;
    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_bai_hat);

        edtTen=findViewById(R.id.edtTen);
        edtCaSi=findViewById(R.id.edtCaSi);
        lv=findViewById(R.id.lv);
        btnThem=findViewById(R.id.btnThem);

        arrayList = new ArrayList<>();
        arrayList.add(new DanhSach("La lung","Vu"));
        arrayList.add(new DanhSach("Dom dom","jack"));

        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex=i;
                DanhSach selectedItem = arrayList.get(i);
                edtTen.setText(selectedItem.getTen());
                edtCaSi.setText(selectedItem.getCasi());
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String casi = edtCaSi.getText().toString();
                arrayList.add( new DanhSach(ten,casi));
                adapter.notifyDataSetChanged();
            }
        });
    }
}