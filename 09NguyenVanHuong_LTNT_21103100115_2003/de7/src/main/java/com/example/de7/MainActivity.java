package com.example.de7;

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

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtCCCD;
    Button btnThem, btnSua, btnXoa;
    ArrayList <CongDan> arrayList;
    ArrayAdapter <CongDan> adapter;
    ListView lv;
    int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtTen=findViewById(R.id.edtTen);
        edtCCCD=findViewById(R.id.edtCCCD);
        btnThem=findViewById(R.id.btnThem);
        btnSua=findViewById(R.id.btnSua);
        btnXoa=findViewById(R.id.btnXóa);
        lv=findViewById(R.id.lv);

        arrayList = new ArrayList<>();
        arrayList.add(new CongDan("Nguyen Van Huong", "21103100114"));
        arrayList.add(new CongDan("Nguyen Trong Bang", "1231323213"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
                CongDan selectedItem = arrayList.get(i);
                edtTen.setText(selectedItem.getHoTen());
                edtCCCD.setText(selectedItem.getCCCD());

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String cccd =edtCCCD.getText().toString();
                arrayList.set(selectedIndex, new CongDan(ten,cccd));
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(selectedIndex);
                adapter.notifyDataSetChanged();
            }
        });
    }
}