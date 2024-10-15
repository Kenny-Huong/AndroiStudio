package com.example.b1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String json_string = "[{" +
            "\"fullname\":\"Nguyen Van A\",\"" +
            "gender\":1,\"" +
            "age\":32,\"" +
            "level\":\"master\",\"" +
            "monthly-salary\":\"2000USD\",\"" +
            "interests\":{\"" +
            "soccer\":true,\"" +
            "swim\":false,\"" +
            "badminton\":true}}," +
            
            "{\"fullname\":\"Nguyen Van B\",\"" +
            "gender\":2,\"" +
            "age\":35,\"" +
            "level\":\"doctor\",\"" +
            "monthly-salary\":\"5000USD\",\"" +
            "interests\":{\"" +
            "soccer\":false,\"" +
            "swim\":true,\"" +
            "badminton\":false}}]";

    Button btnReadJson;
    TextView txtTen_A, txtTuoi_A, txtLevel_A, txtSalary_A, txtGioitinh_A, txtInterests_A;
    TextView txtTen_B, txtTuoi_B, txtLevel_B, txtSalary_B, txtGioitinh_B, txtInterests_B;

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

    private void ThamChieu() {
        btnReadJson = findViewById(R.id.btnReadJson);

        // Nguyen Van A
        txtTen_A = findViewById(R.id.txtTen_A);
        txtTuoi_A = findViewById(R.id.txtTuoi_A);
        txtLevel_A = findViewById(R.id.txtLevel_A);
        txtSalary_A = findViewById(R.id.txtSalary_A);
        txtGioitinh_A = findViewById(R.id.txtGioitinh_A);
        txtInterests_A = findViewById(R.id.txtInterests_A);

        // Nguyen Van B
        txtTen_B = findViewById(R.id.txtTen_B);
        txtTuoi_B = findViewById(R.id.txtTuoi_B);
        txtLevel_B = findViewById(R.id.txtLevel_B);
        txtSalary_B = findViewById(R.id.txtSalary_B);
        txtGioitinh_B = findViewById(R.id.txtGioitinh_B);
        txtInterests_B = findViewById(R.id.txtInterests_B);
    }

    private void ReadJson() {
        try {
            JSONArray jsonArray = new JSONArray(json_string);

            // Đọc thông tin của Nguyen Van A
            JSONObject object_A = jsonArray.getJSONObject(0);
            setPersonDetails(object_A, txtTen_A, txtTuoi_A, txtLevel_A, txtSalary_A, txtGioitinh_A, txtInterests_A);

            // Đọc thông tin của Nguyen Van B
            JSONObject object_B = jsonArray.getJSONObject(1);
            setPersonDetails(object_B, txtTen_B, txtTuoi_B, txtLevel_B, txtSalary_B, txtGioitinh_B, txtInterests_B);

        } catch (JSONException e) {
            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
    }

    private void setPersonDetails(JSONObject object, TextView txtTen, TextView txtTuoi, TextView txtLevel, TextView txtSalary, TextView txtGioitinh, TextView txtInterests) {
        try {
            String ten = object.getString("fullname");
            txtTen.setText("Tên: " + ten);
            txtTuoi.setText("Tuổi: " + object.getInt("age"));

            String level = object.getString("level");
            String salary = object.getString("monthly-salary");
            txtLevel.setText("Trình độ: " + level);
            txtSalary.setText("Lương: " + salary);

            boolean isMale = object.getInt("gender") == 1;
            txtGioitinh.setText("Giới tính: " + (isMale ? "Nam" : "Nữ"));

            JSONObject interests = object.getJSONObject("interests");
            String interestsString = "Bóng đá: " + interests.getBoolean("soccer") +
                    "\nBơi: " + interests.getBoolean("swim") +
                    "\nCầu lông: " + interests.getBoolean("badminton");
            txtInterests.setText("Sở thích:\n" + interestsString);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
