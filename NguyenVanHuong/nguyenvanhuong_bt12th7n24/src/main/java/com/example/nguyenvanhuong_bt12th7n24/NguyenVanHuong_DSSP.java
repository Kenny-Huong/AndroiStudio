package com.example.nguyenvanhuong_bt12th7n24;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class NguyenVanHuong_DSSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nguyen_van_huong_dssp);
        ListView lv_dssp = findViewById(R.id.lv_dssp);

        ArrayList<Phone> phones = new ArrayList<>();
        phones.add(new Phone("1", "Phone 1", "$500"));
        phones.add(new Phone("2", "Phone 2", "$600"));
        phones.add(new Phone("3", "Phone 3", "$700"));
        phones.add(new Phone("4", "Phone 4", "$800"));
        // Add more phones as needed

        PhoneAdapter adapter = new PhoneAdapter(this, phones);
        lv_dssp.setAdapter(adapter);

        lv_dssp.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Display the toast message
                Phone selectedProduct = phones.get(position);
                String message = "Bạn đang nhấn giữ chuột\n" + "Sản phẩm: " + selectedProduct.getName();
                Toast.makeText(NguyenVanHuong_DSSP.this, message, Toast.LENGTH_SHORT).show();

                // Use a handler to delay the transition to the DetailActivity
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Phone selectedProduct = phones.get(position);
                        Intent intent = new Intent(NguyenVanHuong_DSSP.this, NguyenVanHuong_CTSP.class);
                        intent.putExtra("productCode", selectedProduct.getCode());
                        intent.putExtra("productName", selectedProduct.getName());
                        intent.putExtra("productPrice", selectedProduct.getPrice());
                        startActivity(intent);
                    }
                }, Toast.LENGTH_SHORT); // Delay time (Toast.LENGTH_SHORT duration)
                return true;
            }
        });

    }
}