package com.test.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.test.myapplication.Adapter.ViewPaperAdapter;


public class MainActivity extends AppCompatActivity {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        tabLayout= findViewById(R.id.tabs);
        viewPager= findViewById(R.id.vp_main);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");

        Bundle bundle = new Bundle();
        bundle.putString("email", email);
// set Fragmentclass Arguments
        FRTopics fragTopic = new FRTopics();
        FRTCustom fragCustom = new FRTCustom();
        FRTUser fragUser = new FRTUser();

        fragTopic.setArguments(bundle);
        fragCustom.setArguments(bundle);
        fragUser.setArguments(bundle);

        ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager());
        viewPaperAdapter.AddFragment(fragTopic,"Topics");
        viewPaperAdapter.AddFragment(fragCustom,"Challenge");
        viewPaperAdapter.AddFragment(fragUser,"User");

        viewPager.setAdapter(viewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }
    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }
}
