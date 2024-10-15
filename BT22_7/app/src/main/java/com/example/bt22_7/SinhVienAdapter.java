package com.example.bt22_7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    Context context;
    LayoutInflater li;
    ArrayList<SinhVien>listsv;
    private TextView txtma,txtten,txtgioitinh,txtdiem;
    public SinhVienAdapter(Context context, ArrayList<SinhVien> listsv) {
        this.context = (Context) context;
        this.listsv = listsv;
        this.li = (LayoutInflater) ((Context) context).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listsv.size();
    }

    @Override
    public Object getItem(int i) {
        return listsv.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = li.inflate(R.layout.item_list, null);
        txtma = view.findViewById(R.id.txtma);
        txtten = view.findViewById(R.id.txtten);
        txtgioitinh = view.findViewById(R.id.txtgioitinh);
        txtdiem = view.findViewById(R.id.txtdiem);
        SinhVien sv = listsv.get(i);

        txtma.setText(sv.getMa());
        txtten.setText(sv.getTen());
        txtgioitinh.setText(sv.getGioitinh());
        txtdiem.setText(String.valueOf(sv.getDiem()));

        return view;
    }
}
