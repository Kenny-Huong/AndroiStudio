package com.example.nguyenvanhuong_menu;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class lien_he extends AppCompatActivity {
    private EditText edtPhone;
    private Button btnAdd;
    private Button btnCall;
    private Button btnTiep;
    private ListView phoneListView;
    private ArrayList<String> phoneNumbers;
    private ArrayAdapter<String> adapter1;
    int selectedPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lien_he);

        edtPhone = findViewById(R.id.edtPhone);
        btnAdd = findViewById(R.id.btnAdd);
        btnCall = findViewById(R.id.btnCall);
        btnTiep = findViewById(R.id.btnTiep);
        phoneListView = findViewById(R.id.lv1);

        // Initialize the product list
        phoneNumbers = new ArrayList<>();
        phoneNumbers.add("0328869196");
        phoneNumbers.add("0328765872");
        phoneNumbers.add("0127563829");
        phoneNumbers.add("113");

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,phoneNumbers);
        ListView lvSDT = findViewById(R.id.lv1);
        lvSDT.setAdapter(adapter1);

        lvSDT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String SDT = phoneNumbers.get(i);
                selectedPosition = i;
                edtPhone.setText(SDT);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = edtPhone.getText().toString();
                if (!newItem.isEmpty()) {
                    phoneNumbers.add(newItem);
                    adapter1.notifyDataSetChanged();
                    edtPhone.setText("");
                    Toast.makeText(lien_he.this, "Đã thêm", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(lien_he.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + edtPhone.getText().toString()));

                if (ActivityCompat.checkSelfPermission(lien_he.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(lien_he.this, new
                            String[]{android.Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(callintent);
            }
        });
    }
}