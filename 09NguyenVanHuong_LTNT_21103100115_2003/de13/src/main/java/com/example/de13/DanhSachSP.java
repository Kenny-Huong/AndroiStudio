package com.example.de13;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class DanhSachSP extends AppCompatActivity {
    ListView lv;
    ArrayList <HoaQUA> arrayList;
    ArrayAdapter <HoaQUA> adapter;

    int selectedIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_sp);

        lv=findViewById(R.id.lv);
        arrayList=new ArrayList<>();
        arrayList.add(new HoaQUA(R.drawable.img, "Banana"));
        arrayList.add(new HoaQUA(R.drawable.img_1, "Apple"));
        arrayList.add(new HoaQUA(R.drawable.img_2, "WaterMelon"));

        adapter=new ArrayAdapter<HoaQUA>(DanhSachSP.this,0,arrayList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView=layoutInflater.inflate(R.layout.itemhoaqua,null);
                ImageView img =convertView.findViewById(R.id.img);
                TextView tv = convertView.findViewById(R.id.tv);

                HoaQUA hq1 = arrayList.get(position);
                tv.setText(hq1.getTen());
                img.setImageResource(hq1.getHinh());

                return convertView;
            }
        };
        lv.setAdapter(adapter);



        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex=i;
                arrayList.remove(selectedIndex);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}