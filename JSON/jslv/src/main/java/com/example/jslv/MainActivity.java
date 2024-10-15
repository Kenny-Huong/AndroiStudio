package com.example.jslv;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewFruits = findViewById(R.id.listViewFruits);

        String jsonString = "[" +
                "{\"fullname\":\"Nguyen Van A\",\"gender\":1,\"age\":32,\"level\":\"master\",\"monthly-salary\":\"2000USD\",\"interests\":{\"soccer\":true,\"swim\":false,\"badminton\":true}}," +
                "{\"fullname\":\"Nguyen Van B\",\"gender\":2,\"age\":35,\"level\":\"doctor\",\"monthly-salary\":\"5000USD\",\"interests\":{\"soccer\":false,\"swim\":true,\"badminton\":false}}" +
                "]";

        Gson gson = new Gson();
        Type personListType = new TypeToken<List<Person>>(){}.getType();
        List<Person> personList = gson.fromJson(jsonString, personListType);

        PersonAdapter adapter = new PersonAdapter(this, personList);
        listViewFruits.setAdapter(adapter);
    }
    }
}