package com.peter.Farejudge;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import java.text.DateFormat;
import java.util.Calendar;


public class Profile extends AppCompatActivity {


    TextView name, mail;
    Button logout,activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        Calendar calendar;
        calendar = Calendar.getInstance();
        String CurrentDate = DateFormat.getDateInstance(DateFormat.LONG).format(calendar.getTime());
        TextView date = (TextView) findViewById(R.id.date);
        date.setText(CurrentDate);


      logouta();
      activity=(Button) findViewById(R.id.buttona);
      activity.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              goback();

          }
      });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                    startActivity(new Intent(getApplicationContext(),
                            home.class));
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),
                                Profile.class));
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),
                                Details.class));
                        return true;
                }

                return false;
            }
        });


    }
    private void goback(){

        Intent intent = new Intent (this, Details.class);
        startActivity(intent);

    }

    public void logouta(){


        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}