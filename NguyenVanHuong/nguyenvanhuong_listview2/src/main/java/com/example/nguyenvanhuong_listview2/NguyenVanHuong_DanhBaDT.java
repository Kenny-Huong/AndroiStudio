package com.example.nguyenvanhuong_listview2;

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

public class    NguyenVanHuong_DanhBaDT extends AppCompatActivity {
//Khai Báo Biến
    EditText edtTen, edtSDT;
    Button btnThem, btnSua, btnXoa;
    ListView lv;
    //Khai báo Arraylist
    ArrayList <String> arrayList_phone;
    //Khai báo ArrayAdapter
    ArrayAdapter arrayAdapter_phone;
    int vitri=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_danh_ba_dt);
        //Ánh Xạ
        lv=findViewById(R.id.lv);
        edtTen=findViewById(R.id.edtTen);
        edtSDT=findViewById(R.id.edtSDT);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        //Tạo ArrayList và thêm các phần tử vào ArrayList
        arrayList_phone=new ArrayList<>();
        //Tạo 1 đối tượng thuộc lớp Phone
        Phone phone1 = new Phone("Nguyễn Văn A","0328869196");
        String phonechuoi1 = phone1.getTen()+"-"+phone1.getSdt();
        Phone phone2 = new Phone("Nguyễn Văn B","0328869100");
        String phonechuoi2 = phone2.getTen()+"-"+phone2.getSdt();
        Phone phone3 = new Phone("Nguyễn Văn C","0328869200");
        String phonechuoi3 = phone3.getTen()+"-"+phone3.getSdt();
        Phone phone4 = new Phone("Nguyễn Văn D","0328869300");
        String phonechuoi4 = phone4.getTen()+"-"+phone4.getSdt();
        Phone phone5 = new Phone("Nguyễn Văn E","0328869400");
        String phonechuoi5 = phone5.getTen()+"-"+phone5.getSdt();

        arrayList_phone.add(phonechuoi1);
        arrayList_phone.add(phonechuoi2);
        arrayList_phone.add(phonechuoi3);
        arrayList_phone.add(phonechuoi4);
        arrayList_phone.add(phonechuoi5);

        //Tạo ArrayAdapte và gán ArrayList ln ArrayAdapter
        arrayAdapter_phone=new ArrayAdapter<>(NguyenVanHuong_DanhBaDT.this, android.R.layout.simple_list_item_1, arrayList_phone);
        //Đưa ArrayAdapter lên ListView
        lv.setAdapter(arrayAdapter_phone);

        //Viết sự kiện kích chuột vào một đối tượng trên Listview
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Lấy tên, sdt được chọn trên ListView
                String selectedItem = arrayList_phone.get(i);
                String[] parts = selectedItem.split("-");
                String hoTen = parts[0].trim();
                String sdt = parts[1].trim();

                //Gán lên editText
                edtTen.setText(hoTen);
                edtSDT.setText(sdt);

                vitri=i;

            }
        });
        //Thực hiện nút Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Lấy tên được nhập từ EditText
                String hoTen = edtTen.getText().toString();
                //Lấy sdt được nhập từ Editext
                String sdt = edtSDT.getText().toString();
                arrayList_phone.add(hoTen+"-"+sdt);
                arrayAdapter_phone.notifyDataSetChanged();
            }
        });
        //Thực hiện nút sửa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtTen.getText().toString();
                String sdt = edtSDT.getText().toString();
                arrayList_phone.set(vitri, hoTen+"-"+sdt);

                arrayAdapter_phone.notifyDataSetChanged();
            }
        });

        //Thực hiện nút Xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList_phone.remove(vitri);
                arrayAdapter_phone.notifyDataSetChanged();
            }
        });
    }
}