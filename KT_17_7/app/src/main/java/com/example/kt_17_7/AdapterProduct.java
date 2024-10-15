package com.example.kt_17_7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterProduct extends BaseAdapter  {

    private Context context;
    private LayoutInflater li;
    private ArrayList<Product>listprodut;

    public AdapterProduct(Context context, ArrayList<Product> listprodut) {
        this.context = context;
        this.listprodut = listprodut;
        this.li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listprodut.size();
    }

    @Override
    public Object getItem(int i) {
        return listprodut.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = this.li.inflate(R.layout.custom, null);

        TextView txtmasp, txtloaisp, txttensp, txtgia;
        ImageView imagesp;

        txtmasp = view.findViewById(R.id.txtmasp);
        txtloaisp = view.findViewById(R.id.txtloaisp);
        txttensp = view.findViewById(R.id.txttensp);
        txtgia = view.findViewById(R.id.txtgia);
        imagesp = view.findViewById(R.id.imagesp);


        Product pr = listprodut.get(i);

        txtmasp.setText("Mã phòng: " + pr.getMasp());
        txtloaisp.setText("Loại phòng: " + pr.getLoaisp());
        txttensp.setText("Tên phòng: " + pr.getTensp());
        txtgia.setText("Giá: " + pr.getGia());
        imagesp.setImageResource(pr.getImg());

        return view;
    }
}
