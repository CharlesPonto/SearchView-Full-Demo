package com.example.practice1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    String[] programmingLanguages = { "HTML", "CSS", "JavaScript", "Java", "Python", "C", "C++", "C#",
            "PHP", "Ruby", "Swift", "Kotlin", "Go", "Rust", "TypeScript",
            "SQL", "R", "Perl", "Scala", "Dart" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //bind
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);

        //adapter
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, programmingLanguages);
        listView.setAdapter(arrayAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return true;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                arrayAdapter.getFilter().filter(query);
                return true;
            }
        });
    }
}