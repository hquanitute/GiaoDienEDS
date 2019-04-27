package com.test.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.myapplication.Adapter.ViewPaperAdapter;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout= findViewById(R.id.tabs);
        viewPager= findViewById(R.id.vp_main);
        ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager());
        viewPaperAdapter.AddFragment(new FRTopics(),"Topics");
        viewPaperAdapter.AddFragment(new FRTCustom(),"Custom");
        viewPaperAdapter.AddFragment(new user(),"User");

        viewPager.setAdapter(viewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
