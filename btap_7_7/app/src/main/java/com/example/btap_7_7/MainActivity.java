package com.example.btap_7_7;

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
       int  id = item.getItemId();
       if (id == R.id.hoa_don1){
           Intent myintent = new Intent(MainActivity.this, hoa_don.class);
           startActivity(myintent);
       }else if (id == R.id.cham_soc1){
           Intent myintent = new Intent(MainActivity.this, cham_soc.class);
           Toast.makeText(this, "Chức năng chưa được cập nhật", Toast.LENGTH_SHORT).show();

       }
       else if (id == R.id.lien_he1){
           Intent myintent = new Intent(MainActivity.this, lien_he.class);
           Toast.makeText(this, "Chức năng chưa được cập nhật", Toast.LENGTH_SHORT).show();

       }
       else if (id == R.id.thoat1){
           Intent myintent = new Intent(MainActivity.this, thoat.class);
           System.exit(0);
       }
       return super.onOptionsItemSelected(item);
    }
}