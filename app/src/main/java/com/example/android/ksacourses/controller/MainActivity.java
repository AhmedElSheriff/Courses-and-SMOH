package com.example.android.ksacourses.controller;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.ksacourses.R;
import com.example.android.ksacourses.adapters.ViewPagerAdapter;
import com.example.android.ksacourses.fragments.CoursesFragment;
import com.example.android.ksacourses.fragments.DiscusFragment;
import com.example.android.ksacourses.fragments.NewsFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new MainActivityFragment()).commit();
//        }

        TabLayout tabLayout = findViewById(R.id.tablayout_id);
        ViewPager viewPager = findViewById(R.id.viewpager_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new NewsFragment(),"News");
        adapter.AddFragment(new CoursesFragment(), "Courses");
        adapter.AddFragment(new DiscusFragment(), "Discussions");
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
