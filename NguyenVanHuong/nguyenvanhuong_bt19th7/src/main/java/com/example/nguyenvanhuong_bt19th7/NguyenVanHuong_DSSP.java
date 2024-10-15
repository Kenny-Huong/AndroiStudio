package com.example.nguyenvanhuong_bt19th7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NguyenVanHuong_DSSP extends AppCompatActivity {
    ListView lv_dssp;
    Button btnCTSP, btnThoatMain;
    //Khai báo ArrayList
    ArrayList <SanPham> arrayList_dssp;
    //Khai báo ArrayAdapter
    ArrayAdapter <SanPham> arrayAdapter_dssp;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_dssp);

        lv_dssp=findViewById(R.id.lv_dssp);
        btnCTSP=findViewById(R.id.btnCTSP);
        btnThoatMain=findViewById(R.id.btnThoatMain);

        //Tạo ArrayList và thêm các phần tử vào ListView
        arrayList_dssp=new ArrayList<>();
        SanPham sp1 = new SanPham("DT01", "iPhone 13", "20000000");
        SanPham sp2 = new SanPham("DT02", "Samsung Galaxy S21", "18000000");
        SanPham sp3 = new SanPham("DT03", "Xiaomi Mi 11", "15000000");
        SanPham sp4 = new SanPham("DT04", "OnePlus 9", "17000000");
        SanPham sp5 = new SanPham("DT05", "Google Pixel 6", "19000000");


        arrayList_dssp.add(sp1);
        arrayList_dssp.add(sp2);
        arrayList_dssp.add(sp3);
        arrayList_dssp.add(sp4);
        arrayList_dssp.add(sp5);

        //Tạo ArrayAdapter và gắn ArrayList lên
        arrayAdapter_dssp=new ArrayAdapter<>(NguyenVanHuong_DSSP.this, android.R.layout.simple_list_item_1, arrayList_dssp);
        //Đưa ArrayAdapter lên ListView
        lv_dssp.setAdapter(arrayAdapter_dssp);

        lv_dssp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Display the toast message
                SanPham selectedProduct = arrayList_dssp.get(position);
                String message = "- Mã Sản Phẩm : "+selectedProduct.getMaSP()+" - Sản Phẩm :" + selectedProduct.getTenSP()+"- Đơn Gía : "+selectedProduct.getDonGia();
                Toast.makeText(NguyenVanHuong_DSSP.this, message, Toast.LENGTH_SHORT).show();
                vitri = position;
                return true;
                // Use a handler to delay the transition to the DetailActivity
            }
        });

        btnThoatMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnCTSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vitri != -1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            SanPham selectedProduct = arrayList_dssp.get(vitri);
                            Intent intent = new Intent(NguyenVanHuong_DSSP.this, NguyenVanHuong_CTSP.class);
                            intent.putExtra("productCode", selectedProduct.getMaSP());
                            intent.putExtra("productName", selectedProduct.getTenSP());
                            intent.putExtra("productPrice", selectedProduct.getDonGia());
                            startActivity(intent);
                        }
                    }, 200); // Delay time in milliseconds
                } else {
                    Toast.makeText(NguyenVanHuong_DSSP.this, "Vui lòng chọn sản phẩm trước khi xem chi tiết.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}