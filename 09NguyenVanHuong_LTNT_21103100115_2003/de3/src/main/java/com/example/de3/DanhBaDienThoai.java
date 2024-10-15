package com.example.de3;

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

public class DanhBaDienThoai extends AppCompatActivity {
    ListView lv;
    Button btnChiTiet, btnXoa;
    ArrayList<DanhBa> arrayList;
    ArrayAdapter<DanhBa> adapter;
    int selectIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_ba_dien_thoai);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lv = findViewById(R.id.lv);
        btnChiTiet = findViewById(R.id.btnChiTiet);
        btnXoa = findViewById(R.id.btnXoa);

        arrayList = new ArrayList<>();
        arrayList.add(new DanhBa("Nguyen Van Huong", "0328869196"));
        arrayList.add(new DanhBa("Nguyen Viet Cuong", "012321123"));
        arrayList.add(new DanhBa("Nguyen Tuan Dat", "112112312312"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arrayList);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectIndex = i;
            }
        });

        btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectIndex != -1){
                    Intent intent = new Intent(DanhBaDienThoai.this,ChiTiet.class);
                    intent.putExtra("ten", arrayList.get(selectIndex).getTen());
                    intent.putExtra("sdt", arrayList.get(selectIndex).getSdt());
                    startActivity(intent);
                }else {
                    Toast.makeText(DanhBaDienThoai.this, "Vui lòng chọn 1 liên hệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectIndex != -1){
                    arrayList.remove(selectIndex);
                    adapter.notifyDataSetChanged();
                    lv.clearChoices();
                    selectIndex = -1;
                    Toast.makeText(DanhBaDienThoai.this, "Xoa Thanh Cong", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(DanhBaDienThoai.this, "Vui lòng chọn 1 liên hệ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}