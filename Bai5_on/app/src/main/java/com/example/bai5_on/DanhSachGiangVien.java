package com.example.bai5_on;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class DanhSachGiangVien extends AppCompatActivity {
    private EditText txtTengv, txtSdt;
    private Button btnThem, btnXoa, btnTiep;
    private ListView listviewgv;
    private ArrayList<String> dsgv = new ArrayList<>(Arrays.asList("Nguyễn Văn An-091222222", "Nguyễn Thị Na-097912345", "Hoàng Xuân Hương-098991234"));
    private ArrayAdapter<String> adapter = null;

    private int poscurr = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_danh_sach_giang_vien);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtTengv = findViewById(R.id.txtTengv);
        txtSdt = findViewById(R.id.txtSdt);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnTiep = findViewById(R.id.btnTiep);
        listviewgv = findViewById(R.id.listviewgv);

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsgv);
        listviewgv.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hotem = txtTengv.getText().toString();
                String sdt = txtSdt.getText().toString();

                if (hotem.isEmpty() || sdt.isEmpty()) {
                    Toast.makeText(DanhSachGiangVien.this, "Chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    dsgv.add(hotem + "-" + sdt);
                    adapter.notifyDataSetChanged();
                    txtTengv.setText("");
                    txtSdt.setText("");
                }
            }
        });

        listviewgv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                poscurr = i;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (poscurr != -1) {
                    dsgv.remove(poscurr);
                    adapter.notifyDataSetChanged();
                    poscurr = -1;
                }else {
                    Toast.makeText(DanhSachGiangVien.this, "Chưa chọn giảng viên", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(DanhSachGiangVien.this, Json.class);
                startActivity(I);
            }
        });

    }
}