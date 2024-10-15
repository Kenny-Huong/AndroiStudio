package com.example.baitap8_7;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivityBai4 extends AppCompatActivity {
    ListView ListPerson;

    String listcolor [] = {"#0000fe", "#00ffff", "#fe0002", "#ffff01", "#03fe01"};
    ArrayList<Person> dsPerson = new ArrayList<>(Arrays.asList(
            new Person("Pham Thanh Toan", "0332123349"),
            new Person("Do Dinh Tien", "0332678594"),
            new Person("Bui Thi Hoa Mai", "2093747890"),
            new Person("Nguyen Thi Tra", "0897356782"),
            new Person("Dinh Thi Thom", "03758748966"),
            new Person("Hoang Thuy Linh", "045781359541"),
            new Person("Nguyen Thu Phuong", "09875623535"),
            new Person("Vu Thi Anh", "09875623535")
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bai4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        int stt = 0;
        int lengtcl = listcolor.length;
        for (Person ps : dsPerson) {
            ps.setSTT(stt+1);
            
            if(stt > listcolor.length){
                ps.setMausac(listcolor[stt % lengtcl]);
            } else if(stt == 0|| stt == listcolor.length){
                ps.setMausac(listcolor[0]);
            }
            else {
                ps.setMausac(listcolor[stt]);
            }

            stt++;
        }
        MyArrayAdapter myadapter = new MyArrayAdapter(dsPerson);
        ListPerson = findViewById(R.id.ListPerson);
        ListPerson.setAdapter(myadapter);
    }
}