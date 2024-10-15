package com.example.baitaponlistviewjson1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String JsonStr = "[\r\n    {\r\n    \"fullname\": \"Nguyen Van A\", \r\n    \"gender\": 1,\r\n    \"age\": 32,\r\n    \"level\": \"master\",\r\n    \"monthly-salary\" : \"2000USD\",\r\n    \"interests\" : \r\n        {\r\n            \"soccer\": true, \r\n            \"swim\": false,\r\n            \"badminton\" : true\r\n        }\r\n    },\r\n    {\r\n    \"fullname\": \"Nguyen Van B\",\r\n    \"gender\": 2,\r\n    \"age\": 35,\r\n    \"level\": \"doctor\",\r\n    \"monthly-salary\" : \"5000USD\",\r\n    \"interests\":\r\n        {\r\n        \"soccer\": false,\r\n        \"swim\": true,\r\n        \"badminton\" : false\r\n        }\r\n    }\r\n]";
    Button btnReadData;
    ListView ListviewObject;
    ArrayList<InfoPersons> listInfo = null;

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

        listInfo = new ArrayList<>();
        btnReadData = findViewById(R.id.btnReadData);
        ListviewObject = findViewById(R.id.ListviewObject);

        handeldata();

        btnReadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdapterInfoPerson adapter = new AdapterInfoPerson(MainActivity.this, listInfo);
                ListviewObject.setAdapter(adapter);
            }
        });

    }

    private void handeldata() {
        try {

            JSONArray arrayObject = new JSONArray(JsonStr);

            for (int i = 0; i < arrayObject.length(); i++) {
                JSONObject obj = arrayObject.getJSONObject(i);
                String name = obj.getString("fullname");
                int gd = obj.getInt("gender");
                int Age = obj.getInt("age");
                String levl = obj.getString("level");
                String salary = obj.getString("monthly-salary");

                JSONObject inters = obj.getJSONObject("interests");

                boolean[] arrinterests = new boolean[] {
                        inters.getBoolean("soccer"),
                        inters.getBoolean("swim"),
                        inters.getBoolean("badminton")
                };
                InfoPersons ps = new InfoPersons(name, gd, Age, levl, salary, arrinterests);
                listInfo.add(ps);
            }

        } catch (JSONException e) {
            Log.e("errorto", e.getMessage());
        }

    }
}