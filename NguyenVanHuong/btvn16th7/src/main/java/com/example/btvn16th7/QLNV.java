package com.example.btvn16th7;

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

public class QLNV extends AppCompatActivity {
    EditText edtMNV, edtTNV;
    Button btnThem, btnSua, btnXoa;
    ListView lv;
    //Khai báo Arraylist
    ArrayList <String> arrayList_dsnv;
    //Khai báo ArrayAdapter
    ArrayAdapter arrayAdapter_dsnv;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_qlnv);

        edtMNV=findViewById(R.id.edtMNV);
        edtTNV=findViewById(R.id.edtTNV);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        lv=findViewById(R.id.lv);

        //Tạo ArrayList và thêm các phần tử vào ArrayList
        arrayList_dsnv =new ArrayList<>();
        //Tạo 1 đối tượng thuộc lớp Phone
        DSNV dsnv1 = new DSNV("ab1","Nguyễn Văn Hướng");
        String dsnvchuoi1 = dsnv1.getMNV()+"-"+dsnv1.getTNV();
        DSNV dsnv2 = new DSNV("cx3","Nguyễn Trọng Bằng");
        String dsnvchuoi2 = dsnv2.getMNV()+"-"+dsnv2.getTNV();

        arrayList_dsnv.add(dsnvchuoi1);
        arrayList_dsnv.add(dsnvchuoi2);

        //Tạo ArrayAdapte và gán ArrayList lên ArrayAdapter
        arrayAdapter_dsnv=new ArrayAdapter<>(QLNV.this, android.R.layout.simple_list_item_1, arrayList_dsnv);
        //Đưa ArrayAdapter lên ListView
        lv.setAdapter(arrayAdapter_dsnv);

        //Viết sự kiện kích chuột vào một đối tượng trên Listview
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Lấy tên, sdt được chọn trên ListView
                String selectedItem = arrayList_dsnv.get(i);
                String[] parts = selectedItem.split("-");
                String MNV = parts[0].trim();
                String TNV = parts[1].trim();

                //Gán lên editText
                edtMNV.setText(MNV);
                edtTNV.setText(TNV);

                vitri=i;
            }
        });
        //Thực hiện nút Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy tên được nhập từ EditText
                String MNV = edtMNV.getText().toString();
                //Lấy sdt được nhập từ Editext
                String TNV = edtTNV.getText().toString();
                arrayList_dsnv.add(MNV+"-"+TNV);
                arrayAdapter_dsnv.notifyDataSetChanged();
            }
        });
        //Thực hiện nút sửa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String MNV = edtMNV.getText().toString();
                String TNV = edtTNV.getText().toString();
                arrayList_dsnv.set(vitri, MNV+"-"+TNV);
                arrayAdapter_dsnv.notifyDataSetChanged();
            }
        });

        //Thực hiện nút Xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList_dsnv.remove(vitri);
                arrayAdapter_dsnv.notifyDataSetChanged();
            }
        });
    }
}