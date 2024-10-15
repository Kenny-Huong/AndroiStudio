package com.example.demo_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    private Context context;
    private List<Person> persons;

    public PersonAdapter(Context context, List<Person> persons) {
        super(context, 0, persons);
        this.context = context;
        this.persons = persons;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false);
        }

        Person person = persons.get(position);

        TextView number = convertView.findViewById(R.id.number);
        TextView fullname = convertView.findViewById(R.id.fullname);
        TextView gender = convertView.findViewById(R.id.gender);
        TextView age = convertView.findViewById(R.id.age);
        TextView level = convertView.findViewById(R.id.level);
        TextView monthly_salary = convertView.findViewById(R.id.monthly_salary);
        CheckBox checkboxSoccer = convertView.findViewById(R.id.checkbox_soccer);
        CheckBox checkboxSwim = convertView.findViewById(R.id.checkbox_swim);
        CheckBox checkboxBadminton = convertView.findViewById(R.id.checkbox_badminton);

        number.setText(String.valueOf(position + 1));
        fullname.setText(person.getFullname());
        gender.setText(person.getGender() == 1 ? "Male" : "Female");
        age.setText("Age: " + person.getAge());
        level.setText("Level: " + person.getLevel());
        monthly_salary.setText("Salary: " + person.getMonthly_salary());

        checkboxSoccer.setChecked(person.getInterests().isSoccer());
        checkboxSwim.setChecked(person.getInterests().isSwim());
        checkboxBadminton.setChecked(person.getInterests().isBadminton());

        // Đặt màu nền cho TextView số
        int[] colors = {android.R.color.holo_blue_dark, android.R.color.holo_red_light, android.R.color.holo_red_dark, android.R.color.holo_orange_light};
        number.setBackgroundResource(colors[position % colors.length]);

        return convertView;
    }
}
