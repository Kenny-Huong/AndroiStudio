package com.example.baitaponlistviewjson1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterInfoPerson extends BaseAdapter {

    private ArrayList<InfoPersons> listInfo;
    private Context context;
    private LayoutInflater li;

    public AdapterInfoPerson(Context context, ArrayList<InfoPersons> listInfo) {
        this.context = context;
        this.listInfo = listInfo;
        this.li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listInfo.size();
    }

    @Override
    public Object getItem(int i) {
        return listInfo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = this.li.inflate(R.layout.item_list, null);

        TextView txtfullname, txtgender , txtage, txtlevel, txtmonthlysalary;
        CheckBox cbsocer, cbswim, cbbadmintion;

        txtfullname = view.findViewById(R.id.txtfullname);
        txtgender = view.findViewById(R.id.txtgender);
        txtage = view.findViewById(R.id.txtage);
        txtlevel = view.findViewById(R.id.txtlevel);
        txtmonthlysalary = view.findViewById(R.id.txtmonthlysalary);
        cbsocer = view.findViewById(R.id.cbsocer);
        cbswim = view.findViewById(R.id.cbswim);
        cbbadmintion = view.findViewById(R.id.cbbadmintion);

        InfoPersons ips = listInfo.get(i);
        String fullname = ips.getFullname();
        String gender = ips.getGender() == 1 ? "Nam" : "Nữ";
        int age = ips.getAge();
        String level = ips.getLevel();
        String monthlysalary = ips.getMonthlysalary();
        boolean []interests = ips.getInterest();

        txtfullname.setText(fullname);
        txtgender.setText(gender);
        txtage.setText(""+age);
        txtlevel.setText(level);
        txtmonthlysalary.setText(monthlysalary);
        if(interests[0]) {
            cbsocer.setChecked(true);
        } else if (interests[1]) {
            cbswim.setChecked(true);
        }else if (interests[2]) {
            cbbadmintion.setChecked(true);
        }

        return view;
    }
}
