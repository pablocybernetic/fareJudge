package com.peter.Farejudge;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class EstablishmentListActivity extends AppCompatActivity {

    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,  DatabaseHelper.NAME,DatabaseHelper.SUBJECT, DatabaseHelper.DESC,DatabaseHelper.DATE};

    final int[] to = new int[] { R.id.id, R.id.nameEst ,R.id.title, R.id.desc,R.id.date1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                AddEstablishment.class));
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),
                                Profile.class));
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),
                                EditEstablishmentActivity.class));
                        return true;
                }

                return false;
            }
        });





        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor1 = dbManager.search("hi");

        Cursor cursor = dbManager.fetch();
        ArrayList<String[]> mArrayList = new ArrayList<String[]>();
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            // The Cursor is now set to the right position
            mArrayList.add(cursor.getColumnNames());
        }



        listView = (ListView) findViewById(R.id.list_view);
        listView.setEmptyView(findViewById(R.id.empty));


        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record, cursor, from, to, 0);
        listView.setAdapter(adapter);

        EditText searchView = findViewById(R.id.search);
        Toast.makeText(this, ""+ cursor, Toast.LENGTH_LONG).show();

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                adapter = new SimpleCursorAdapter(TextWatcher, R.layout.activity_view_record, cursor, from, to, 0);
                adapter = new SimpleCursorAdapter(EstablishmentListActivity.this,  R.layout.activity_view_record, cursor, from, to, 0);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);


            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                Cursor cursor1 = dbManager.search(s.toString());
                adapter = new SimpleCursorAdapter(EstablishmentListActivity.this,  R.layout.activity_view_record, cursor1, from, to, 0);
                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        String nik = from.toString();
        Toast.makeText(this, "to"+nik, Toast.LENGTH_LONG).show();

        // OnCLickListener For List Items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView = (TextView) view.findViewById(R.id.id);
                TextView titleTextView = (TextView) view.findViewById(R.id.title);
//                TextView dateTextView = (TextView) view.findViewById(R.id.date1);
                TextView descTextView = (TextView) view.findViewById(R.id.desc);



                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                String desc = descTextView.getText().toString();
//                String date = dateTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), EditEstablishmentActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

                startActivity(modify_intent);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add_record) {

            Intent add_mem = new Intent(this, AddEstablishment.class);
            startActivity(add_mem);

        }
        return super.onOptionsItemSelected(item);
    }

}
