package com.example.bai5_on;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

public class Json extends AppCompatActivity {
    private Button btnShow;
    private ListView listviewdt;

    private String jsondata =
            "[" +
                    "{" +
                        "\"ma\": 01 ," +
                        "\"ten\": \"SamSung s23\" ," +
                        "\"hang\": \"SamSung\" ," +
                        "\"gia\": 15000000" +
                    "}, "+
                    "{" +
                        "\"ma\": 02 ," +
                        "\"ten\": \"Oppo reno23\"," +
                        "\"hang\": \"Oppo\"," +
                        "\"gia\": 9000000" +
                    "}, " +
                    "{" +
                        "\"ma\": 03," +
                        "\"ten\": \"Iphone 15\"," +
                        "\"hang\": \"Apple\"," +
                        "\"gia\": 25000000" +
                    "} " +
            "]";

    private ArrayAdapter<DienThoai>adapter2 = null;
    private ArrayList<DienThoai> listdt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnShow = findViewById(R.id.btnShow);
        listviewdt = findViewById(R.id.listviewdt);

        listdt = new ArrayList<>();
        getdataJson();

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter2 = new ArrayAdapter<>(Json.this, android.R.layout.simple_list_item_1, listdt);
                listviewdt.setAdapter(adapter2);
            }
        });

    }

    private void getdataJson() {
        try {
            JSONArray arr = new JSONArray(this.jsondata);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                int ma = obj.getInt("ma");
                String ten = obj.getString("ten");
                String hang = obj.getString("hang");
                int gia = obj.getInt("gia");

                DienThoai dtn = new DienThoai(ma, ten, hang, gia);
                listdt.add(dtn);

            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}