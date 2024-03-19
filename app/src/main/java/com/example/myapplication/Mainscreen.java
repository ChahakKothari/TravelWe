package com.example.myapplication;

//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.viewpager2.widget.ViewPager2;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.MenuItem;
//import android.widget.Toast;

//import com.google.android.material.bottomnavigation.BottomNavigationView;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
public class Mainscreen extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
//    ViewPager2 viewPager2;
private Handler sliderHandler =new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);
//
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        viewPager2 = findViewById(R.id.viewPager);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();
                if (id == R.id.nav_hotel) {

                    Intent intent = new Intent(Mainscreen.this, hotels.class);
                    startActivity(intent);
                } else if (id == R.id.nav_slideshow) {
                    Intent intent = new Intent(Mainscreen.this, taxi.class);
                    startActivity(intent);
                }

                else if (id == R.id.nav_cities) {
                    Intent intent = new Intent(Mainscreen.this, taxi.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(Mainscreen.this, "not working", Toast.LENGTH_SHORT).show();
                }
                return true;
            }


        });

    }
}