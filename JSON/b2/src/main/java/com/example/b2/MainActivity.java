package com.example.b2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String json_string = "[{\"id\":\"1\",\"title\":\"Điện thoại vivo V25 Pro 5G\",\"price\":\"8190000\",\"type\":\"Điện thoại\"},{\"id\":\"3\",\"title\":\"Laptop Asus Gaming TUF\",\"price\":\"8000000\",\"type\":\"Máy tính\"},{\"id\":\"4\",\"title\":\"Laptop Apple MacBook Air 13 inch M1\",\"price\":\"18690000\",\"type\":\"Máy tính\"},{\"id\":\"5\",\"title\":\"Điện thoại iPhone (Apple)\",\"price\":\"2749000\",\"type\":\"Điện thoại\"},{\"id\":\"6\",\"title\":\"Điện thoại Samsung Galaxy S24 5G 256GB\",\"price\":\"2299000\",\"type\":\"Điện thoại\"}]";

    Button btnReadJson;
    LinearLayout productsContainer;

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
        productsContainer = findViewById(R.id.productsContainer);
    }

    private void ReadJson() {
        try {
            JSONArray jsonArray = new JSONArray(json_string);

            // Xóa tất cả các sản phẩm hiện có trong productsContainer trước khi thêm các sản phẩm mới
            productsContainer.removeAllViews();

            // Lặp qua từng sản phẩm trong JSON array và thêm nó vào productsContainer
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject product = jsonArray.getJSONObject(i);

                String id = product.getString("id");
                String title = product.getString("title");
                String price = product.getString("price");
                String type = product.getString("type");

                // Tạo một TextView để hiển thị thông tin của sản phẩm
                TextView productView = new TextView(this);
                productView.setText("ID: " + id + "\nTitle: " + title + "\nPrice: " + price + "\nType: " + type);
                productView.setPadding(0, 16, 0, 16);

                // Thêm TextView vào productsContainer
                productsContainer.addView(productView);
            }
        } catch (JSONException e) {
            Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
    }
}
