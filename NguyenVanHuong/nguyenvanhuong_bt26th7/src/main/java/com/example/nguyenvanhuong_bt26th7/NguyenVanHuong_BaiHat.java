package com.example.nguyenvanhuong_bt26th7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class NguyenVanHuong_BaiHat extends AppCompatActivity {
    ListView lv1;
    EditText edtTen, edtTacGia;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;
    Button btnThem, btnSua, btnXoa;
    int selectedPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_bai_hat);
        lv1 = findViewById(R.id.lv1);
        edtTen = findViewById(R.id.edtTen);
        edtTacGia = findViewById(R.id.edtTacGia);
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        arrayList = new ArrayList<>();

        BaiHat bh1 = new BaiHat("Đom đóm", "Jack");
        String BH1 = bh1.getTen()+" - "+bh1.getTacgia();
        BaiHat bh2 = new BaiHat("Hồng Nhan", "Trịnh Trần Phương Tuấn");
        String BH2 = bh2.getTen()+" - "+bh2.getTacgia();
        BaiHat bh3 = new BaiHat("Thiên Lý Oiiii", "J97");
        String BH3 = bh3.getTen()+" - "+bh3.getTacgia();


        arrayList.add(BH1);
        arrayList.add(BH2);
        arrayList.add(BH3);


        adapter = new ArrayAdapter<>(NguyenVanHuong_BaiHat.this, android.R.layout.simple_list_item_1,arrayList);
        lv1.setAdapter(adapter);


        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = arrayList.get(position);
                String[] parts = selectedItem.split(" - ");
                String ten = parts[0].trim();
                String bai = parts[1].trim();
                selectedPosition=position;
                Intent intent = new Intent(NguyenVanHuong_BaiHat.this, NguyenVanHuong_CTBH.class);
                intent.putExtra("Ten", ten);
                intent.putExtra("Baihat ", bai);
                startActivity(intent);
            }
        });


    }
}