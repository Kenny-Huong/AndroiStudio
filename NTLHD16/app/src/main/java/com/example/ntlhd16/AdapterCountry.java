package com.example.ntlhd16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterCountry extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Country> arraylist;

    public AdapterCountry(Context context, int layout, List<Country> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parnet){
        View convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        convertView = inflater.inflate(layout, null);
        Country country = arraylist.get(position);
        TextView textV1 = convertView.findViewById(R.id.name);
        TextView textV2 = convertView.findViewById(R.id.mota);
        ImageView imageV = convertView.findViewById(R.id.imageHinh);

        textV1.setText(country.getTennuoc());
        textV2.setText(country.getMota());
        imageV.setImageResource(country.getHinh());
        return convertView;
    }
}
