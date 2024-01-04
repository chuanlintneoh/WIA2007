package com.example.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button BtnMeow, BtnFindLocMap, BtnNearbyPlaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnMeow = findViewById(R.id.BtnMeow);
        BtnFindLocMap = findViewById(R.id.BtnFindLocMap);
        BtnNearbyPlaces = findViewById(R.id.BtnNearbyPlaces);

        BtnMeow.setOnClickListener(view -> {
            Intent intent = new Intent(this, GetCurrentLocation.class);
            startActivity(intent);
        });
        BtnFindLocMap.setOnClickListener(view -> {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        });
        BtnNearbyPlaces.setOnClickListener(view -> {
            Intent intent = new Intent(this, FindNearbyPlaces.class);
            startActivity(intent);
        });
    }
}