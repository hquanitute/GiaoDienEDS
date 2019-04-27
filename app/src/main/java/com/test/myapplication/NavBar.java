package com.test.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class NavBar extends Fragment {
    TabItem btnTopics;
    TabItem btnCustom;
    TabItem btnUser;
    public NavBar() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_nav_bar,container,false);

        btnTopics =(TabItem) view.findViewById(R.id.tabTopics);
        btnUser= (TabItem)view.findViewById(R.id.tabUser);
        btnCustom=(TabItem) view.findViewById(R.id.tabCustom);

        btnTopics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FRTopics();
                chuyenFrg(fragment);
            }
        });
        return view;
    }
    public  void chuyenFrg(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContent,fragment);
        fragmentTransaction.commit();
    }
}
