package com.example.baitap8_7;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivityBai1 extends AppCompatActivity {
    ListView ListItemsFood;
    Button btnAdd, btnEdit, btnSearch, btnDelete;
    EditText txtItem;

    ArrayList<String> Foods =  new ArrayList<>(Arrays.asList("Banh my", "Trung", "Sua", "Gao", "My tom", "Thit bo"));
    ArrayAdapter<String>adapter;
    private  int posItem=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bai1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout rootLayout = findViewById(R.id.root_layout1);
        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hideKeyboard();
                return false;
            }
        });




        ListItemsFood = findViewById(R.id.ListItemsFood);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnSearch = findViewById(R.id.btnSearch);
        btnDelete = findViewById(R.id.btnDelete);
        txtItem = findViewById(R.id.txtItem);

        adapter = new ArrayAdapter<>(MainActivityBai1.this, android.R.layout.simple_list_item_1, Foods);
        ListItemsFood.setAdapter(adapter);


        ListItemsFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtItem.setText(Foods.get(i).toString());
                posItem = i;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = txtItem.getText().toString().trim();
                if(!item.isEmpty()){
                    if(Foods.contains(item)){
                        Toast.makeText(MainActivityBai1.this, "Item đã tồn tại", Toast.LENGTH_SHORT).show();
                    }else {
                        Foods.add(item);
                        adapter.notifyDataSetChanged();
                        txtItem.setText("");
                    }
                }else {
                    Toast.makeText(MainActivityBai1.this, "Chưa nhập gì", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posItem >= 0){
                    Foods.remove(posItem);
                    adapter.notifyDataSetChanged();
                    posItem = -1;
                    txtItem.setText("");
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strs = txtItem.getText().toString().trim();
                List<String> rs = Foods.stream().filter(x -> x.toLowerCase().contains(strs.toLowerCase())).collect(Collectors.toList());
                ArrayList<String> rsn = new ArrayList<>(rs);
                ArrayAdapter adp = new ArrayAdapter<>(MainActivityBai1.this, android.R.layout.simple_list_item_1, rsn);
                ListItemsFood.setAdapter(adp);
            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(posItem >= 0){
                    String ItemUp = txtItem.getText().toString().trim();
                    Foods.set(posItem, ItemUp);
                    adapter.notifyDataSetChanged();
                    posItem = -1;
                    txtItem.setText("");
                }else {
                    Toast.makeText(MainActivityBai1.this, "Chưa chọn item", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


}