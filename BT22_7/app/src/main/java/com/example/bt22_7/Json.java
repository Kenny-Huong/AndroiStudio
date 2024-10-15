package com.example.bt22_7;

import android.os.Bundle;
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

public class Json extends AppCompatActivity {
    private ListView lv2;
    private Button buttonShowdata;
    private String datajson = "[\n    " +
            "{\n    " +
                "\"ma\":\"1\"," +
                "\"ten\":\"Hương nè\"," +
                "\"gioitinh\":\"nữ\"," +
                "\"diem\":9.5\n    " +
            "},\n    " +

            "{\n    " +
                "\"ma\":\"2\"," +
                "\"ten\":\"Đức đần\"," +
                "\"gioitinh\":\"nam\"," +
                "\"diem\":9\n    " +
            "},\n    " +

            "{\n    " +
                "\"ma\":\"3\"," +
                "\"ten\":\"Hoài Nam\"," +
                "\"gioitinh\":\"nữ\"," +
                "\"diem\":9.5\n   " +
            "}" +
            "\n]";
    private ArrayList<SinhVien>listsv = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_json);

        listsv = new ArrayList<>();
        GetdataJson();

        lv2 = findViewById(R.id.lv2);
        buttonShowdata = findViewById(R.id.buttonShowdata);

        buttonShowdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SinhVienAdapter adapter = new SinhVienAdapter(Json.this, listsv);
                lv2.setAdapter(adapter);
            }
        });

    }

    private void GetdataJson() {

        JSONArray arr = null;
        try {
            arr = new JSONArray(this.datajson);
            for (int i = 0; i < arr.length(); i++){
                JSONObject obj = arr.getJSONObject(i);
                String ma = obj.getString("ma");
                String ten = obj.getString("ten");
                String gioitinh = obj.getString("gioitinh");
                double diem = obj.getDouble("diem");

                SinhVien sv = new SinhVien(ma, ten, gioitinh, diem);
                listsv.add(sv);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }
}