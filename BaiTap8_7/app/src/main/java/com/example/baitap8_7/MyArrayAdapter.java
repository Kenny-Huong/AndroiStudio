package com.example.baitap8_7;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends BaseAdapter {
    final ArrayList<Person> listPerson;


    public MyArrayAdapter(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }

    @Override
    public int getCount() {
        return listPerson.size();
    }

    @Override
    public Object getItem(int i) {
        return listPerson.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_custom, null);
        } else viewProduct = convertView;

        Person ps =(Person) getItem(i);
        ((TextView)viewProduct.findViewById(R.id.txtStt)).setText(String.valueOf(ps.getSTT()));
        ((LinearLayout)viewProduct.findViewById(R.id.linershape)).setBackgroundColor(Color.parseColor(ps.getMausac()));
        ((TextView)viewProduct.findViewById(R.id.txtHoten)).setText(ps.getHoten());
        ((TextView)viewProduct.findViewById(R.id.txtSdt)).setText(ps.getSdt());

        return viewProduct;
    }
}
