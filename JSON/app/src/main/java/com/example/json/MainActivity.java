package com.example.json;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String json_string = "{\n"+
            "\"name\":\"Nguyễn Văn Nam\",\n"+
            "\"id\":1,\n"+
            "\"age\":37,\n"+
            "\"skill\":[\n"+
            "\"sing\",\n"+
            "\"dance\",\n"+
            "\"play piano\"\n"+
            "],\n"+

            "\"isMale\":true,\n"+
            "\"family\":{\n"+
            "\"father\":\"Nguyễn Văn A\",\n"+
            "\"mother\":\"Nguyễn Thị C\"\n"+
            "}\n"+

            "}";
Button btnReadJson;
TextView txtID,txtTen,txtTuoi,txtSKILL,txtGioitinh,txtFamily;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThamChieu();
        btnReadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadJson();
            }
        });

    }
    private void ThamChieu()
    {
        btnReadJson = findViewById(R.id.btnReadJson);
        txtID = findViewById(R.id.txtID);
        txtTen = findViewById(R.id.txtTen);
        txtTuoi = findViewById(R.id.txtTuoi);
        txtSKILL = findViewById(R.id.txtSKILL);
        txtGioitinh = findViewById(R.id.txtGioitinh);
        txtFamily = findViewById(R.id.txtFamily);
    }
    private void ReadJson()
    {
        try {
            JSONObject object = new JSONObject(json_string);
            String ten = object.getString("name");
            txtTen.setText("Ten: "+ten);
            txtID.setText(("Ma: "+object.getInt("id")));
            txtTuoi.setText("Tuoi: "+object.getInt("age"));
            JSONArray arraySk = object.getJSONArray("skill");
            String s = "";
            for(int i=0; i<arraySk.length(); i++){
                s += arraySk.get(i).toString() + ", ";
            }
           txtSKILL.setText("Ky nang: "+ s);
            boolean isMale = object.getBoolean("isMale");
            if(isMale){
                txtGioitinh.setText("Gioi tinh: Nam");
            }else{
                txtGioitinh.setText("Gioi tinh: Nu");
            }
            JSONObject object1 = object.getJSONObject("family");
            String s1 = "";
            s1 += object1.getString("father")+ ", ";
            s1 += object1.getString("mother");
            txtFamily.setText("Gia dinh: "+ s1);
        } catch (JSONException e) {
            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }

    }
}