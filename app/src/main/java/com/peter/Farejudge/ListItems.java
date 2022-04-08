package com.peter.Farejudge;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListItems extends AppCompatActivity {
    protected ListView listView;
    protected Layout card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);


//create object of listview
        ListView listView=(ListView)findViewById(R.id.listview);


//create ArrayList of String
        final ArrayList<String> arrayList=new ArrayList<>();

//Add elements to arraylist
        arrayList.add("android");
        arrayList.add("is");
        arrayList.add("great");
        arrayList.add("and I love it");
        arrayList.add("It");
        arrayList.add("is");
        arrayList.add("better");
        arrayList.add("then");
        arrayList.add("many");
        arrayList.add("other");
        arrayList.add("operating system.");
        arrayList.add("android");
        arrayList.add("is");
        arrayList.add("great");
        arrayList.add("and I love it");
        arrayList.add("It");
        arrayList.add("is");
        arrayList.add("better");
        arrayList.add("then");
        arrayList.add("many");
        arrayList.add("other");
        arrayList.add("operating system.");
        final ArrayList<String> images=new ArrayList<>();
        images.add("23 ");
        images.add("read ");
        images.add(" you");
        images.add(" tyu ");
        images.add("23 ");
        images.add("read ");
        images.add(" you");
        images.add(" tyu ");
        images.add("23 ");
        images.add("read ");
        images.add(" you");
        images.add(" tyu ");
        images.add("23 ");
        images.add("read ");
        images.add(" you");
        images.add(" tyu ");



//Create Adapter
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        ArrayAdapter ImagearrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,images);

//assign adapter to listview
        listView.setAdapter(arrayAdapter);

//add listener to listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListItems.this, "clicked item:"+i+" "+arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}