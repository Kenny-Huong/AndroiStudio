package com.example.nguyenvanhuong_bt25th7;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class NguyenVanHuong_danhba25th7 extends AppCompatActivity {
    ListView lv1;
    EditText edtTen, edtSDT;
    ArrayList<String> arrPhone;
    ArrayAdapter adapterPhone;
    Button btnThem, btnSua, btnXoa;
    int selectedPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        lv1 = findViewById(R.id.lv1);
        edtTen = findViewById(R.id.edtTen);
        edtSDT = findViewById(R.id.edtSDT);
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        arrPhone = new ArrayList<>();

        NguyenVanHuong_Phone phone1 = new NguyenVanHuong_Phone("Nguyễn Văn A", "098231456");
        String phoneC1 = phone1.getTen()+" - "+phone1.getSdt();
        NguyenVanHuong_Phone phone2 = new NguyenVanHuong_Phone("Phạm Thị C", "0989123321");
        String phoneC2 = phone2.getTen()+" - "+phone2.getSdt();
        NguyenVanHuong_Phone phone3 = new NguyenVanHuong_Phone("Bùi Minh T", "0972221972");
        String phoneC3 = phone3.getTen()+" - "+phone3.getSdt();


        arrPhone.add(phoneC1);
        arrPhone.add(phoneC2);
        arrPhone.add(phoneC3);


        adapterPhone = new ArrayAdapter<>(NguyenVanHuong_danhba25th7.this, android.R.layout.simple_list_item_1,arrPhone);
        lv1.setAdapter(adapterPhone);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = arrPhone.get(i);
                String[] parts = selectedItem.split("-");
                String ten = parts[0].trim();
                String sdt = parts[1].trim();

                //Gán lên editText
                edtTen.setText(ten);
                edtSDT.setText(sdt);

                selectedPosition=i;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtTen.getText().toString();
                //Lấy sdt được nhập từ Editext
                String sdt = edtSDT.getText().toString();
                arrPhone.add(ten + "-" + sdt);
                adapterPhone.notifyDataSetChanged();
                Toast.makeText(NguyenVanHuong_danhba25th7.this, "Đã thêm thành công:  " + ten +" - "+ sdt + " vào danh bạ.", Toast.LENGTH_SHORT).show();

            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    String ten = edtTen.getText().toString();
                    String sdt = edtSDT.getText().toString();
                    if (!ten.isEmpty()&&(!sdt.isEmpty())) {

                        arrPhone.set(selectedPosition, ten);
                        arrPhone.set(selectedPosition, sdt);
                        adapterPhone.notifyDataSetChanged();
                        edtTen.setText("");
                        edtSDT.setText("");
                        Toast.makeText(NguyenVanHuong_danhba25th7.this, "Đã sửa", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(NguyenVanHuong_danhba25th7.this, "Vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(NguyenVanHuong_danhba25th7.this, "Chọn một mục để sửa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    String ten = edtTen.getText().toString();
                    String sdt = edtSDT.getText().toString();
                    String xoa = arrPhone.get(selectedPosition);
                    arrPhone.remove(xoa);
                    adapterPhone.notifyDataSetChanged();
                    edtSDT.setText("");
                    edtTen.setText("");
                    Toast.makeText(NguyenVanHuong_danhba25th7.this, "Đã xóa: "+ten+" - "+sdt, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NguyenVanHuong_danhba25th7.this, "Chọn một mục để xóa", Toast.LENGTH_SHORT).show();
                }
            }
        });
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent callintent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:" + edtSDT.getText().toString()));

                if (ActivityCompat.checkSelfPermission(NguyenVanHuong_danhba25th7.this,
                        android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(NguyenVanHuong_danhba25th7.this, new
                            String[]{android.Manifest.permission.CALL_PHONE}, 1);

                }

                startActivity(callintent);
                return true;
            }
        });

    }
}