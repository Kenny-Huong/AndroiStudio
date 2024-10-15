package com.example.nguyenvanhuong;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class BaiTap2_7 extends AppCompatActivity {
    EditText edtTen, edtCMND;
    Button btnGui;
    RadioButton rbtn1, rbtn2, rbtn3;
    CheckBox cb1, cb2, cb3;
    TextView tv1;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bai_tap27);
        edtTen = findViewById(R.id.edtTen);
        edtCMND = findViewById(R.id.edtCMND);
        btnGui = findViewById(R.id.btnGui);
        rbtn1 = findViewById(R.id.rbtn1);
        rbtn2 = findViewById(R.id.rbtn2);
        rbtn3 = findViewById(R.id.rbtn3);
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        tv1 = findViewById(R.id.tv1);
        radioGroup = findViewById(R.id.radioGroup);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                String CMND = edtCMND.getText().toString();
                // Kiểm tra điều kiện nhập đủ thông tin


                String BangCap = "";
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
                    BangCap = selectedRadioButton.getText().toString();
                }
                StringBuilder SoThich = new StringBuilder();
                if (cb1.isChecked()) {
                    SoThich.append(cb1.getText().toString()).append(", ");
                }
                if (cb2.isChecked()) {
                    SoThich.append(cb2.getText().toString()).append(", ");
                }
                if (cb3.isChecked()) {
                    SoThich.append(cb3.getText().toString());
                }
                List<String> missingFields = new ArrayList<>();

                if (ten.equals("")) {
                    missingFields.add("Họ Tên");
                }
                if (CMND.equals("")) {
                    missingFields.add("Chứng Minh Nhân Dân");
                }
                if(BangCap.equals("")){
                    missingFields.add("Hãy chọn 1 bằng cấp");
                }
                if(SoThich.equals("")){
                    missingFields.add("Hãy chọn 1 sở thích");
                }
                if (!missingFields.isEmpty()) {
                    String message = "Bạn chưa nhập đủ thông tin: " + String.join(", ", missingFields);
                    Toast.makeText(BaiTap2_7.this, message, Toast.LENGTH_SHORT).show();
                }else {
                    Intent myintent = new Intent(BaiTap2_7.this, HoTenSV_NguyenVanHuong.class);
                    Bundle mybundle = new Bundle();
                    mybundle.putString("ten", ten);

                    mybundle.putString("cmnd", CMND);
                    mybundle.putString("bangcap", BangCap);
                    mybundle.putString("sothich", String.valueOf(SoThich));
                    mybundle.putString("bosung", tv1.getText().toString());
                    myintent.putExtra("guithongtin", mybundle);
                    ;
                    startActivity(myintent);
                }
            }
        });
    }
}