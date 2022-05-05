package com.peter.Farejudge;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.util.Calendar;


public class Profile extends AppCompatActivity {


    TextView name, mail;
    Button logout,activity;
    ImageView profile ;


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
                            AddEstablishment.class));
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),
                                Profile.class));
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),
                                EstablishmentListActivity.class));
                        return true;
                }

                return false;
            }
        });




    }
    private void goback(){

        Intent intent = new Intent (this, EstablishmentListActivity.class);
        startActivity(intent);

    }

    public void logouta(){


        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());

            profile = findViewById(R.id.btnUpdateImage);
//            Uri photoUrl = user.getPhotoUrl();

//            profile.setImageURI(photoUrl);

        }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            String uid = user.getUid();
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