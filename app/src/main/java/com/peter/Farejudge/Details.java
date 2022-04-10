package com.peter.Farejudge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Details extends AppCompatActivity {
    private long pressedTime;

    // Array of strings storing country names
    String[] visits = new String[] {
            "Ufanisi Resort",
            "Kisii Camel park",
            "Sri Lanka club",
            "Bella Vista Golf",
            "Nairobi National Park",
            "Garden City ",
            "Uhuru PArk",
            "Mwalimu Hotel",
            "WestGate",
            "Ngong Hills"

    };

    // Array of integers points to images stored in /res/drawable-ldpi/
    int[] img = new int[]{
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food,
            R.drawable.food
    };

    // Array of strings to store currencies
    String[] place = new String[]{
            "Kisii CBD",
            "Kisii",
            "Nakuru",
            "Nairobi",
            "Nairobi",
            "Nairobi",
            "Nairobi",
            "Kisii",
            "Ongata Rongai",
            "Ngong"
    };
    final ArrayList<String> arrayList=new ArrayList<>();
//    arrayList.add("hh");
//List<Integer> list=new ArrayList<>();
//    list.add(Integer.valueOf(10));//storing Integer object
//    list.add(20);//Now compiler converts it into Integer.valueOf(20) which is object
//    list.add(30);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        // Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<10;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", "Visits : " + visits[i]);
            hm.put("cur"," Location : " + place[i]);
            hm.put("flag",Integer.toString(img[i]));
            aList.add(hm);
            arrayList.add("hh");
        }

        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };

        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};

        // Instantiating an adapter to store each items
//         R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);

        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Details.this, "clicked item:"+i+" "+place.toString(), Toast.LENGTH_SHORT).show();
            }
        });




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.dashboard);

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
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}