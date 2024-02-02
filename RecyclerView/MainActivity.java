package com.example.drawerlayout2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    NavController navController;

    private AppBarConfiguration mAppBarConfiguration;

    MaterialToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.destRecycler, R.id.destHome, R.id.destAutoComplete)
                .setOpenableLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this,R.id.NHFMain);
        NavigationView navigationView = findViewById(R.id.nav_view);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_view);

        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       if(item.getItemId() == R.id.destHome){
           navController.navigate(R.id.destHome);
           return true;
       }
       else if (item.getItemId() == R.id.destRecycler){
           navController.navigate(R.id.destRecycler);
           return true;
       }
         else if (item.getItemId() == R.id.destAutoComplete){
              navController.navigate(R.id.destAutoComplete);
              return true;
         }
       else
           return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.NHFMain);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}