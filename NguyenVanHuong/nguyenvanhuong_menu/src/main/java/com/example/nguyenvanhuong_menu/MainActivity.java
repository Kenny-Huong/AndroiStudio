package com.example.nguyenvanhuong_menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.giao_dien, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.hdon){
//            Intent myintent = new Intent(MainActivity.this, hoa_don.class);
//            startActivity(myintent);
            Toast.makeText(this, "Chức năng này chưa được cập nhật.", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.LH){
            Intent intent = new Intent(MainActivity.this, lien_he.class);
            startActivity(intent);
        }
        else if(id == R.id.CSKH){
            Toast.makeText(this, "Chức năng này chưa được cập nhật.", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.Thoat){
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}


