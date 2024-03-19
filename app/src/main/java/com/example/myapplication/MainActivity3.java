package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import androidx.appcompat.widget.Toolbar;


import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
/*import android.widget.Toolbar;*/

import com.example.myapplication.ui.PlaceFragment;
import com.example.myapplication.ui.hotelFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
public class MainActivity3 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    ViewPager2 viewPager2;

    private Handler sliderHandler = new Handler();
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        /*drawerLayout.addDrawerListener(toggle);*/
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_service) {
                    openFragment(new Food());
                    return true;
                } else if (itemId == R.id.nav_hotel) {
                    openFragment(new hotelFragment());
                    return true;
                } else if (itemId == R.id.nav_places) {
                    openFragment(new PlaceFragment());
                    return true;
                }

                return false;
            }
        });

        fragmentManager = getSupportFragmentManager();
        openFragment(new Food());

        // Slider related code
        viewPager2 = findViewById(R.id.viewPager);

        List<Sliseitem> sliderItem = new ArrayList<>();
        sliderItem.add(new Sliseitem(R.drawable.slider));
        sliderItem.add(new Sliseitem(R.drawable.imgsli));
        sliderItem.add(new Sliseitem(R.drawable.imadesli));

        viewPager2.setAdapter(new SliderAdapter(sliderItem, viewPager2));

        viewPager2.setClipToPadding(true);
        viewPager2.setClipChildren(true);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositionTransformer = new CompositePageTransformer();
        compositionTransformer.addTransformer(new MarginPageTransformer(30));
        compositionTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositionTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 2000);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_hotel) {
            openFragment(new Food());
        } else if (itemId == R.id.nav_places) {
            openFragment(new hotelFragment());
        } else if (itemId == R.id.nav_cities) {
            openFragment(new PlaceFragment());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}

/*
public class MainActivity3 extends AppCompatActivity {

    ViewPager2 viewPager2;
   */
/* BottomNavigationView bottomNavigationView;*//*


    private Handler sliderHandler =new Handler();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        */
/*bottomNavigationView = findViewById(R.id.bottomNavigationView1);*//*

        viewPager2 = findViewById(R.id.viewPager);

       */
/*bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {*//*

          */
/* @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {


               int id = item.getItemId();
               if (id == R.id.nav_hotel) {

                   Intent intent = new Intent(MainActivity3.this, hotels.class);
                   startActivity(intent);
               } else if (id == R.id.nav_slideshow) {
                   Intent intent = new Intent(MainActivity3.this, taxi.class);
                   startActivity(intent);
               }

               else if (id == R.id.nav_cities) {
                   Intent intent = new Intent(MainActivity3.this, taxi.class);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(MainActivity3.this, "not working", Toast.LENGTH_SHORT).show();
               }
               return true;
           }


       });*//*


      viewPager2=findViewById(R.id.viewPager);


       List<Sliseitem> sliderItem=new ArrayList<>();
       sliderItem.add(new Sliseitem(R.drawable.slider));
        sliderItem.add(new Sliseitem(R.drawable.imgsli));
        sliderItem.add(new Sliseitem(R.drawable.imadesli));

        viewPager2.setAdapter(new SliderAdapter(sliderItem,viewPager2));

        viewPager2.setClipToPadding(true);
        viewPager2.setClipChildren(true);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        CompositePageTransformer compositionTransformer =new CompositePageTransformer();
        compositionTransformer.addTransformer(new MarginPageTransformer(30));
        compositionTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {

                float r=1-Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewPager2.setPageTransformer(compositionTransformer);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable,2000);
            }
        });
    }
    
    private Runnable sliderRunnable =new Runnable() {
        @Override
        public void run() {
           viewPager2.setCurrentItem( viewPager2.getCurrentItem() + 1);
        }
    };
}*/
