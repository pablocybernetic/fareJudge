package com.peter.Farejudge;

import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Establishment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establishment);
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);

    }

}