package com.sudiptahaldarkgec.neetpastyear;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    String []titles;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    private long pressedTime;

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleViewId);

        drawerLayout = findViewById(R.id.drawerLayId);
        navigationView = findViewById(R.id.drawerId);

        adView = findViewById(R.id.bannerId);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);



        toolbar = findViewById(R.id.home_toolbar_id);
        toolbar.setTitle("GATE CS/IT");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.firstId) {
                    Toast.makeText(MainActivity.this, "touch on first", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.shareAppId2) {
                    Toast.makeText(MainActivity.this, "touch on share", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "touched", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


        titles = new String[]{
                "2022 paper with solution",
                "2021 paper with solution",
                "2020 paper with solution",
                "2019 paper with solution",
                "2018 paper with solution",
                "2017 paper with solution",
                "2016 paper with solution",
                "2015 paper with solution",
                "2014 paper with solution",
                "2013 paper with solution",
                "2012 paper with solution",
                "2011 paper with solution",
                "2010 paper with solution",
                "2009 paper with solution",
                "2008 paper with solution",
                "2007 paper with solution",


        };

        customAdapter = new CustomAdapter(this, titles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(customAdapter);


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            if (pressedTime + 1500 > System.currentTimeMillis()) {
                super.onBackPressed();
                finish();
            } else {
                Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
            }
            pressedTime = System.currentTimeMillis();

        }
    }
}