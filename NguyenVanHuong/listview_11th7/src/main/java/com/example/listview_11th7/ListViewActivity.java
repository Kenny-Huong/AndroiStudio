package com.example.listview_11th7;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView lv_mh;
    EditText edtMH;
    Button btnThem1, btnSua1, btnXoa1;
    //Khai báo Arraylist lưu danh sách các sdt
    ArrayList<String> Ds_mh;
    //Khai báo ArrayAdapter
    ArrayAdapter ad_sdt;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);

        // Ánh xạ các id vào các biến giao diện
        lv_mh=findViewById(R.id.lv_sdt);

        edtMH=findViewById(R.id.edtMH);
        btnThem1=findViewById(R.id.btnThem1);
        btnSua1=findViewById(R.id.btnSua1);
        btnXoa1=findViewById(R.id.btnXoa1);

        //Tao ArrayList và thêm các phần từ vào Arraylist
        Ds_mh=new ArrayList<>();
        Ds_mh.add("Toán rời rạc");
        Ds_mh.add("Cấu trúc dữ liệu và giải thuật");
        Ds_mh.add("Phân tích thiết kế he thống");

        //Tạo ArrayAdapter và thực hiện gán ArrayList lên ArrayAdapter
        ad_sdt = new ArrayAdapter<>(ListViewActivity.this, android.R.layout.simple_list_item_1, Ds_mh);

        //Gán ArrayAdapter lên ListView
        lv_mh.setAdapter(ad_sdt);

        //Viết sự kiện kích chuột vào 1 đối tượng trên ListView
        lv_mh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Lấy sdt được chọn trên listview
                String sdt = Ds_mh.get(i);
                //Lấy vị trí sdt vừa chọn
                vitri=i;
                //Gán sdt lên TextView
                //tv_sdt.setText("Số điện thoại vừa chọn là : "+sdt+"ở vị trí "+vitri);
                edtMH.setText(sdt);
            }
        });

        //Thực hiện nút thêm
        btnThem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    //Lấy sdt được nhập vào từ EditText
                    String sdt = edtMH.getText().toString();

                    //Đưa sdt vừa nhập vào Arraylist
                    Ds_mh.add(sdt);
                    ad_sdt.notifyDataSetChanged();
                    Toast.makeText(ListViewActivity.this, "Thêm Thành Công !", Toast.LENGTH_SHORT).show();

            }
        });

        //Thực hiện nút sửa
        btnSua1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sdt = edtMH.getText().toString();
                Ds_mh.set(vitri, sdt);
                ad_sdt.notifyDataSetChanged();
                Toast.makeText(ListViewActivity.this, "Sửa Thành Công !", Toast.LENGTH_SHORT).show();
            }
        });

        //Thực hiện nút xoá
        btnXoa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ds_mh.remove(vitri);
                ad_sdt.notifyDataSetChanged();

                Toast.makeText(ListViewActivity.this, "Xoá Thành Công !!!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}