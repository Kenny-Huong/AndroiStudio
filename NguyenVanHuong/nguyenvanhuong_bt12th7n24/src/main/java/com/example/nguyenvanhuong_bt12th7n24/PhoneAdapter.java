package com.example.nguyenvanhuong_bt12th7n24;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PhoneAdapter extends ArrayAdapter<Phone> {
    public PhoneAdapter(Context context, List<Phone> phones) {
        super(context, 0, phones);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Phone phone = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        TextView phoneName = convertView.findViewById(android.R.id.text1);
        phoneName.setText(phone.getName());

        return convertView;
    }
}
