package com.example.nguuyenvanhuong_bt18th7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class NVH_DanhBa extends AppCompatActivity {
    ListView lvDanhBa;
    //Khai báo ArrayList
    ArrayList <String> arrayList_danhba;
    //Khai báo ArrayAdapter
    ArrayAdapter arrayAdapter_danhba;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nvh_danh_ba);
        lvDanhBa=findViewById(R.id.lvDanhBa);

        //Tạo ArrayList và thêm các phần tử vào ArrayList
        arrayList_danhba = new ArrayList<>();
        // Tạo 5 đối tượng DanhBa với các giá trị khác nhau cho HoTen và SDT
        DanhBa kn1 = new DanhBa("Nguyen Van A", "0123456789");
        String knchuoi1 = kn1.getHoTen() + "_" + kn1.getSDT();

        DanhBa kn2 = new DanhBa("Tran Thi B", "0987654321");
        String knchuoi2 = kn2.getHoTen() + "_" + kn2.getSDT();

        DanhBa kn3 = new DanhBa("Le Van C", "0123987654");
        String knchuoi3 = kn3.getHoTen() + "_" + kn3.getSDT();

        DanhBa kn4 = new DanhBa("Pham Thi D", "0987543210");
        String knchuoi4 = kn4.getHoTen() + "_" + kn4.getSDT();

        DanhBa kn5 = new DanhBa("Hoang Van E", "0167890123");
        String knchuoi5 = kn5.getHoTen() + "_" + kn5.getSDT();

        arrayList_danhba.add(knchuoi1);
        arrayList_danhba.add(knchuoi2);
        arrayList_danhba.add(knchuoi3);
        arrayList_danhba.add(knchuoi4);
        arrayList_danhba.add(knchuoi5);

        //Tạo ArrayAdapter và gán ArrayList lên ArrayAdapter
        arrayAdapter_danhba = new ArrayAdapter<>(NVH_DanhBa.this, android.R.layout.simple_list_item_1, arrayList_danhba);
        //Đưa ArrayAdapter lên LisView
        lvDanhBa.setAdapter(arrayAdapter_danhba);

        //Viết sk khi nhấn giữ 1 đối tượng trên ListView
        lvDanhBa.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Lấy tên , sdt được chọn trên ListView
                String selectedItem = arrayList_danhba.get(i);
                String [] parts = selectedItem.split("_");
                String hoTen = parts[0].trim();
                String sdt = parts[1].trim();

                Toast.makeText(NVH_DanhBa.this, "Bạn đang nhấn giữ sđt "+sdt+" của "+hoTen, Toast.LENGTH_SHORT).show();

                //Gán lên EditText
                Intent intent = new Intent(getApplicationContext(), NVH_LienHe.class);

                //Truyền dữ liệu
                intent.putExtra("ten", hoTen);
                intent.putExtra("sdt", sdt);

                startActivity(intent);


                return true;
            }
        });



    }
}