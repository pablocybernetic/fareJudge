package com.peter.Farejudge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class EditEstablishmentActivity extends Activity implements OnClickListener {

    private EditText titleText, estName;
    private Button updateBtn, deleteBtn;
    private EditText descText;

    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");

        setContentView(R.layout.activity_update_items);


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

        dbManager = new DBManager(this);
        dbManager.open();

        titleText = (EditText) findViewById(R.id.service3);
        descText = (EditText) findViewById(R.id.review3);
        estName = (EditText) findViewById(R.id.estname3) ;


        updateBtn = (Button) findViewById(R.id.update2);
        deleteBtn = (Button) findViewById(R.id.delete2);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");
        String EstName = intent.getStringExtra("name");

        _id = Long.parseLong(id);

        titleText.setText(name);
        descText.setText(desc);
        estName.setText(EstName);

        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update2:
                String title = titleText.getText().toString();
                String desc = descText.getText().toString();
                String EstName = estName.getText().toString();

                dbManager.update(_id, title, desc,EstName);
                this.returnHome();
                break;

            case R.id.delete2:
                dbManager.delete(_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), EstablishmentListActivity.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }
}
