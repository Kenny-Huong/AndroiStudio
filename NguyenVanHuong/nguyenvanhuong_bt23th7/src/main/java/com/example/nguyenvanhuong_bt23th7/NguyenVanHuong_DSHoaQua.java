package com.example.nguyenvanhuong_bt23th7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class NguyenVanHuong_DSHoaQua extends AppCompatActivity {
    ListView lv;
    ArrayList <HoaQua> arrayList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_dshoa_qua);
        lv=findViewById(R.id.lv);
        arrayList=new ArrayList<>();
        HoaQua HQ1 = new HoaQua(R.drawable.img,"Qủa Táo","Đơn giá : 6000Đ");
        HoaQua HQ2 = new HoaQua(R.drawable.img_1,"Qủa Lê","Đơn giá : 8000Đ");
        HoaQua HQ3 = new HoaQua(R.drawable.img_2,"Qủa Chuối","Đơn giá : 12000Đ");
        HoaQua HQ4 = new HoaQua(R.drawable.img_3,"Qủa Mẵng Cầu","Đơn giá : 4000Đ");

        arrayList.add(HQ1);
        arrayList.add(HQ2);
        arrayList.add(HQ3);
        arrayList.add(HQ4);

        adapter = new ArrayAdapter<HoaQua>(NguyenVanHuong_DSHoaQua.this, 0,arrayList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //Kết nối tới file giao diện item phone
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                //Gán các đối tượng lên File giao diện item_phone vào converview
                convertView=layoutInflater.inflate(R.layout.itemhoaqua, null);
                //Khai báo ánh xạ
                TextView tvTen = convertView.findViewById(R.id.tvTen);
                TextView tvGia = convertView.findViewById(R.id.tvGia);
                ImageView img = convertView.findViewById(R.id.img);

                //Lấy 1 phần tử trong ArrayList
                HoaQua hoaqua1 = arrayList.get(position);


                tvTen.setText(hoaqua1.getTen());
                tvGia.setText(hoaqua1.getGia());
                img.setImageResource(hoaqua1.getHinh());
                return convertView;
            }
        };
        lv.setAdapter(adapter);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                HoaQua removedItem = arrayList.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(NguyenVanHuong_DSHoaQua.this, "Đã xóa: " + removedItem.getTen(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}