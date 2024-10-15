package com.example.de3thi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDB;
    private Button buttonChiTiet,buttonXoa;
    private ArrayList<DanhBa> danhBaList;
    private ArrayAdapter<DanhBa> adapter;
    private int selectedIndex = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDB = findViewById(R.id.lvDB);
        buttonChiTiet = findViewById(R.id.buttonChiTiet);
        buttonXoa = findViewById(R.id.buttonXoa);

        danhBaList = new ArrayList<>();
        danhBaList.add(new DanhBa("Minh Công", "0123456789"));
        danhBaList.add(new DanhBa("Hạnh Hoa", "0987654321"));
        danhBaList.add(new DanhBa("Timmy", "0112233445"));
        danhBaList.add(new DanhBa("Tuấn Hưng", "0934565345"));
        danhBaList.add(new DanhBa("Hà Vy", "0223344556"));
        danhBaList.add(new DanhBa("Quang Minh", "0334455667"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, danhBaList);
        lvDB.setAdapter(adapter);
        lvDB.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lvDB.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
            }
        });

        buttonChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    Intent intent = new Intent(MainActivity.this, ChiTiet.class);
                    intent.putExtra("hoten", danhBaList.get(selectedIndex).getHoten());
                    intent.putExtra("sdt", danhBaList.get(selectedIndex).getSdt());
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một liên hệ.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedIndex != -1) {
                    danhBaList.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    lvDB.clearChoices();
                    selectedIndex = -1;
                    Toast.makeText(MainActivity.this, "Đã xoá liên hệ.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn một liên hệ.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}