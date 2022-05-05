package com.peter.Farejudge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEstablishment extends AppCompatActivity implements OnClickListener {

    private Button addTodoBtn;
    private EditText subjectEditText , estaName;
    private EditText descEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Establishments");

        setContentView(R.layout.activity_home);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

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


        subjectEditText = (EditText) findViewById(R.id.estname3);
        descEditText = (EditText) findViewById(R.id.review3);
         estaName = (EditText) findViewById(R.id.service3);
        addTodoBtn = (Button) findViewById(R.id.delete2);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.delete2:

                final String name = subjectEditText.getText().toString();
                if (name.length() <3){
                    Toast.makeText(this, "Establishment Name required", Toast.LENGTH_SHORT).show();
                }else {
                final String desc = descEditText.getText().toString();
                    if (desc.length() <3){
                        Toast.makeText(this, "Please add a review", Toast.LENGTH_SHORT).show();
                    }else {
                        Calendar calendar;
                        calendar = Calendar.getInstance();
                        String CurrentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd  '            at   ' HH:mm:ss ");
                        String currentDateandTime = sdf.format(new Date());

                        final  String estName = estaName.getText().toString();

                        dbManager.insert(estName, name, desc, currentDateandTime);

                Intent main = new Intent(AddEstablishment.this, EstablishmentListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                }}
                break;
        }
    }

}
