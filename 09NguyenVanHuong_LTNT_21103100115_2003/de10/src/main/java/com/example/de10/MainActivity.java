package com.example.de10;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Giao diện chương trình");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.danhsach){
            Intent intent = new Intent(MainActivity.this,DanhSachBaiHat.class);
            startActivity(intent);
        } else if (id == R.id.album) {
            Toast.makeText(this, "Chưa đc cập nhập", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.casi) {
            Toast.makeText(this, "Chưa được cập nhập", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.thoat) {
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}