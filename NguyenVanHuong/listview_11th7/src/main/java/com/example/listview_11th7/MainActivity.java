package com.example.listview_11th7;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edtHoTen, edtSDT;
    Button btnThem, btnSua, btnXoa;
    ListView listView;
    List<DanhBa> danhba = new ArrayList<>();
    ArrayAdapter<DanhBa> adapter = null;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        this.setTitle("Danh sách Danh Bạ");
        AnhXa();
        //Thêm dữ liệu vào ListView
        danhba.add(new DanhBa("Nguyen Van Huong","0328869196"));
        danhba.add(new DanhBa("Nguyen Van A","0328878722"));
        danhba.add(new DanhBa("Nguyen Van B","0345698723"));
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, danhba);
        listView.setAdapter(adapter);

        //Xử lý nút Thêm
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DanhBa db = new DanhBa(edtHoTen.getText().toString(), edtSDT.getText().toString());
                danhba.add(db);
                adapter.notifyDataSetChanged();
                XoaDanhBa();
            }
        });

        //Xử lí chọn item trong ListView để sửa
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitri = i;
                DanhBa db = danhba.get(i);
                edtHoTen.setText(db.getHoten());
                edtSDT.setText(db.getSdt());
            }
        });
        //Xử lý nút sửa
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vitri >= 0){
                    DanhBa db = new DanhBa(edtHoTen.getText().toString(), edtSDT.getText().toString());
                    danhba.set(vitri, db); //Sửa Thông Tin Thay Vì Thêm Mới
                    adapter.notifyDataSetChanged();
                    XoaDanhBa();
                }
            }
        });

        //Xủ lý nút Xoá
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                danhba.remove(vitri);
                adapter.notifyDataSetChanged();
                XoaDanhBa();
            }
        });

    }
    public  void XoaDanhBa(){
        edtHoTen.setText("");
        edtSDT.setText("");
        edtHoTen.requestFocus();
    }
    public void AnhXa(){
        edtHoTen=findViewById(R.id.edtHoTen);
        edtSDT=findViewById(R.id.edtSDT);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXoa);
        listView=findViewById(R.id.listView);
    }
}