package com.example.de14;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DanhSachHoaQua extends AppCompatActivity {
    ListView lv;
    ArrayList <HoaQua> arrayList;
    ArrayAdapter <HoaQua> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_hoa_qua);

        lv=findViewById(R.id.lv);
        arrayList = new ArrayList<>();
        arrayList.add(new HoaQua(R.drawable.img,"Banana","1000"));
        arrayList.add(new HoaQua(R.drawable.img_1,"Apple","2000"));
        arrayList.add(new HoaQua(R.drawable.img_2,"WaterMelon","23000"));

        adapter = new ArrayAdapter<HoaQua>(DanhSachHoaQua.this,0,arrayList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView=layoutInflater.inflate(R.layout.itemhoaqua, null);
                ImageView img = findViewById(R.id.img);
                TextView tv1 = findViewById(R.id.tv1);
                TextView tv2 = findViewById(R.id.tv2);

                HoaQua hq1 = arrayList.get(position);
                img.setImageResource(hq1.getHinh());
                tv1.setText(hq1.getTen());
                tv2.setText(hq1.getGia());
                return convertView;
            }
        };
        lv.setAdapter(adapter);

    }
}