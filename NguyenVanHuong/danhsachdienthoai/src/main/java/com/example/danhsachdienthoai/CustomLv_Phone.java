package com.example.danhsachdienthoai;

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

public class CustomLv_Phone extends AppCompatActivity {
    //Khai báo biến
    ListView lv;
    //khai báo ArrayList
    ArrayList <Phone> arrayList;
    //Khai báo ArrayAdapter
    ArrayAdapter <Phone> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_lv_phone);

        lv=findViewById(R.id.lv);
        //Tạo ArrayList
        arrayList = new ArrayList<>();
        //Thêm các phần tử vào
        Phone P1 = new Phone(R.drawable.img,"Iphone 11");
        arrayList.add(P1);
        Phone P2 = new Phone(R.drawable.img_1,"Vertu");
        arrayList.add(P2);
        Phone P3 = new Phone(R.drawable.img_2, "Samsung");
        arrayList.add(P3);
        Phone P4 = new Phone(R.drawable.img_3, "Điện thoại bàn");
        arrayList.add(P4);

        arrayAdapter = new ArrayAdapter<Phone>(CustomLv_Phone.this, 0,arrayList)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                //Kết nối tới file giao diện item phone
                LayoutInflater layoutInflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                //Gán các đối tượng lên File giao diện item_phone vào converview
                convertView=layoutInflater.inflate(R.layout.layout_itemphone, null);
                //Khai báo ánh xạ
                TextView tv = convertView.findViewById(R.id.tv);
                ImageView img = convertView.findViewById(R.id.img);

                //Lấy 1 phần tử trong ArrayList
                Phone phone1 = arrayList.get(position);

                tv.setText(phone1.getTen());
                img.setImageResource(phone1.getHinh());
                return convertView;
            }
        };
        lv.setAdapter(arrayAdapter);
    }
}