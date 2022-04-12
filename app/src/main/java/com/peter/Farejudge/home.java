package com.peter.Farejudge;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class home extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 1;
    TextView name, mail;
    Button logout,activity,insert, view1;
    EditText name1, contact, dob;
    DBHelper DB;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name1 = findViewById(R.id.estname);
        contact = findViewById(R.id.estlocation);
        dob= findViewById(R.id.review);
        insert = findViewById(R.id.btnInsert);
        DB = new DBHelper(this);
        view1 =findViewById(R.id.view1);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name1.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(home.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(home.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(home.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Location :"+res.getString(1)+"\n");
                    buffer.append("Date of Establishment :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(home.this);
                builder.setCancelable(true);
                builder.setTitle("Establishments");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });




//        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);
//        mail = findViewById(R.id.mail);
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            name.setText(signInAccount.getDisplayName());
//            mail.setText(signInAccount.getEmail());
        }

image  = (ImageView) findViewById(R.id.img);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
                Toast.makeText(home.this, "Select an image from the Gallery", Toast.LENGTH_SHORT).show();
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

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
}