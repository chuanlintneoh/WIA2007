package com.example.animalloverapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);
//        // Initialize NavController
//        navController = Navigation.findNavController(this, R.id.nav_animal_lover);
//        // Set up the BottomNavigationView with the NavController
//        NavigationUI.setupWithNavController(bottomNavigationView,navController);
    }
}