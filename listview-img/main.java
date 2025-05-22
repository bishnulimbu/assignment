
package com.example.uiexample;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String[] data = {"Apple", "Banana", "Cherry", "Date", "Elderberry"};
    int[] images = {R.drawable.ic_apple, R.drawable.ic_banana, R.drawable.ic_cherry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = findViewById(R.id.listView);
        GridView gridView = findViewById(R.id.gridView);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data));
        gridView.setAdapter(new ImageAdapter(this, images));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerAdapter(data));
    }
}
