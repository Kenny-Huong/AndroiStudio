package com.example.demo_json;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button readDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        readDataButton = findViewById(R.id.readDataButton);

        readDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDataAndDisplay();
            }
        });
    }

    private void readDataAndDisplay() {
        // Dữ liệu mẫu JSON
        String json = "[{\"fullname\":\"Nguyen Van A\",\"gender\":1,\"age\":32,\"level\":\"master\",\"monthly_salary\":\"2000USD\",\"interests\":{\"soccer\":true,\"swim\":false,\"badminton\":true}},{\"fullname\":\"Nguyen Van B\",\"gender\":2,\"age\":35,\"level\":\"doctor\",\"monthly_salary\":\"5000USD\",\"interests\":{\"soccer\":false,\"swim\":true,\"badminton\":false}}]";

        Gson gson = new Gson();
        Type personListType = new TypeToken<ArrayList<Person>>(){}.getType();
        List<Person> persons = gson.fromJson(json, personListType);

        PersonAdapter adapter = new PersonAdapter(this, persons);
        listView.setAdapter(adapter);
    }
}
