//package com.peter.Farejudge;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.navigation.NavigationBarView;
//
//public class UpdateItems extends AppCompatActivity {
//    EditText name, contact, dob;
//
//    private DBHelper DB;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_update_items);
//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setSelectedItemId(R.id.home);
//
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.home:
//                        startActivity(new Intent(getApplicationContext(),
//                                home.class));
//                        return true;
//                    case R.id.profile:
//                        startActivity(new Intent(getApplicationContext(),
//                                Profile.class));
//                        return true;
//                    case R.id.dashboard:
//                        startActivity(new Intent(getApplicationContext(),
//                                Details.class));
//                        return true;
//                }
//
//                return false;
//            }
//        });
//        name = findViewById(R.id.estname2);
//        name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                deleteitem();
//            }
//        });
//
//    }
//    void deleteitem(){
//        String nameTXT = name.getText().toString();
//        Boolean checkudeletedata = DB.deletedata(nameTXT);
//        if(checkudeletedata==true)
//            Toast.makeText(UpdateItems.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
//        else
//            Toast.makeText(UpdateItems.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
//    }
//}