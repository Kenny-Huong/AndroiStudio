package com.example.ntlhd16;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListFood extends AppCompatActivity {

    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView listView;
    EditText editTextItem;
    private int editPosition = -1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);

        listView = findViewById(R.id.listView);
        editTextItem = findViewById(R.id.editTextItem);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonEdit = findViewById(R.id.buttonEdit);
        Button buttonSearch = findViewById(R.id.buttonSearch);
        Button buttonDelete = findViewById(R.id.buttonDelete);

        items = new ArrayList<>();
        items.add("Banh my");
        items.add("Trung");
        items.add("Sua");
        items.add("Gao");
        items.add("My tom");
        items.add("Thit bo");

        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editItem();
            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchItem();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem();
            }
        });
    }
    private void addItem() {
        String itemText = editTextItem.getText().toString();
        if (!itemText.isEmpty()) {
            itemsAdapter.add(itemText);
            editTextItem.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Please enter text", Toast.LENGTH_SHORT).show();
        }
    }

    private void editItem() {
        String itemText = editTextItem.getText().toString();
        if (!itemText.isEmpty() && editPosition != -1) {
            items.set(editPosition, itemText);
            itemsAdapter.notifyDataSetChanged();
            editTextItem.setText("");
            editPosition = -1;
        } else {
            Toast.makeText(getApplicationContext(), "Please select an item to edit", Toast.LENGTH_SHORT).show();
        }
    }

    private void searchItem() {
        String itemText = editTextItem.getText().toString();
        if (items.contains(itemText)) {
            Toast.makeText(getApplicationContext(), "Item found: " + itemText, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Item not found", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteItem() {
        String itemText = editTextItem.getText().toString();
        if (items.contains(itemText)) {
            itemsAdapter.remove(itemText);
            editTextItem.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Item not found", Toast.LENGTH_SHORT).show();
        }
    }
}