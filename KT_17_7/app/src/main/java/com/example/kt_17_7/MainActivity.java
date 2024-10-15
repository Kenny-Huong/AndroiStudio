package com.example.kt_17_7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kt_17_7.MainActivityThem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Product> listproduct = new ArrayList<>(Arrays.asList(
            new Product("001", "Phòng đơn", "25 mét vuông", 15000000, R.drawable.image_icon),
            new Product("002", "Phòng đôi", "view biển", 30000000, R.drawable.image_icon),
            new Product("003", "Phòng đơn", "có ban công", 18000000, R.drawable.image_icon),
            new Product("004", "Phòng đôi", "có bồn tắm", 20000000, R.drawable.image_icon),
            new Product("005", "Phòng đơn", "view triệu đô", 22000000, R.drawable.image_icon)
    ));

    AdapterProduct adpter;
    ListView ListviewPrd;
    Button btnThem, btnSua, btnThoat;
    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnThoat = findViewById(R.id.btnThoat);
        btnSua = findViewById(R.id.btnSua);
        btnThem = findViewById(R.id.btnThem);
        ListviewPrd = findViewById(R.id.ListviewPrd);

        adpter = new AdapterProduct(this, listproduct);
        ListviewPrd.setAdapter(adpter);

        ListviewPrd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos = i;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this, MainActivityThem.class);

                if (pos >= 0) {
                    Product p = listproduct.get(pos);
                    I.putExtra("product", p);
                    startActivityForResult(I, 1001);
                } else {
                    Toast.makeText(MainActivity.this, "Chưa chọn phòng", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1001) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "test to", Toast.LENGTH_SHORT).show();
                Product p = (Product) data.getParcelableExtra("prdn");
                if (p != null) {
                    listproduct.set(pos, p);
                    adpter.notifyDataSetChanged();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);

        }
    }
}