package com.example.ntlhd16;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListViewCountry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_country);

        ListView listView;
        ArrayList<Country> arrayList;
        AdapterCountry adapterCountry;
        listView = findViewById(R.id.listviewcountry);
        arrayList = new ArrayList<>();
        arrayList.add(new Country("Việt Nam", "Population : 98000000", R.drawable.vietnam));
        arrayList.add(new Country("United States", "Population : 320000000", R.drawable.united));
        arrayList.add(new Country("Russian", "Population : 142000000",R.drawable.russian));

        adapterCountry = new AdapterCountry(ListViewCountry.this, R.layout.layout_country, arrayList);
        listView.setAdapter(adapterCountry);
    }
}