package com.example.jslv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person>
{
    public PersonAdapter(Context context, List<Person> persons) {
        super(context, 0, (List<Person>) Collections.singletonList(persons));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_person, parent, false);
        }

        TextView textViewFullname = convertView.findViewById(R.id.textViewFullname);
        TextView textViewAge = convertView.findViewById(R.id.textViewAge);
        TextView textViewLevel = convertView.findViewById(R.id.textViewLevel);
        TextView textViewSalary = convertView.findViewById(R.id.textViewSalary);

        textViewFullname.setText(person.getFullname());
        textViewAge.setText("Age: " + person.getAge());
        textViewLevel.setText("Level: " + person.getLevel());
        textViewSalary.setText("Salary: " + person.getMonthlySalary());

        return convertView;
    }
}
