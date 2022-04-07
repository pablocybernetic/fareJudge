package com.peter.Farejudge;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ListItems extends AppCompatActivity {
    protected ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);

        String[] values = new String[]{
                "helo me in", "helo me h h h in", "helo me in","helo me in", "helo me h h h in", "helo me in", "helo me in", "helo me h h h in", "helo me in","helo me in"
        };
        ListView listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListItems.this, android.R.layout.simple_list_item_1, values);
        listView.setAdapter(adapter);
    }

}