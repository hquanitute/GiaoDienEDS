package com.test.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

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
        FRTUser fragUser = new FRTUser();
        FRTHelp fragHelp = new FRTHelp();
        FRTopics fragTopic = new FRTopics();
       BangXepHang_test fragCustom = new BangXepHang_test();


        fragUser.setArguments(bundle);
        fragHelp.setArguments(bundle);
        fragTopic.setArguments(bundle);
        fragCustom.setArguments(bundle);


        ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager());
        viewPaperAdapter.AddFragment(fragUser,"Hồ sơ");
        viewPaperAdapter.AddFragment(fragHelp,"Thể lệ");
        viewPaperAdapter.AddFragment(fragTopic,"Thi đấu");
        viewPaperAdapter.AddFragment(fragCustom,"BXH");

        viewPager.setAdapter(viewPaperAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.user);
        tabLayout.getTabAt(1).setIcon(R.drawable.help);
        tabLayout.getTabAt(2).setIcon(R.drawable.fight);
        tabLayout.getTabAt(3).setIcon(R.drawable.result);



        /*tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(a).getIcon().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_IN);*/




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
