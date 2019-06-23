package com.test.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.test.myapplication.Adapter.test;
import com.test.myapplication.objects.resulttest;

import java.util.ArrayList;

public class BangXepHang_test extends Fragment {
    ListView lvReults;
    ArrayList<resulttest> results;
    test adapter;
    View view;
    String email;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        email = getArguments().getString("email");
        View view = inflater.inflate(R.layout.activity_bang_xep_hang_test, container, false);
        lvReults = view.findViewById(R.id.lvChartTest);
        results = new ArrayList<>();
        results.add(new resulttest("hung1997@gmail.com",550,"a"));
        results.add(new resulttest("nhuhao231gmail.com",530,"b"));
        results.add(new resulttest("tuananhtran123@gmail.com",520,"c"));
        results.add(new resulttest("vominhquang2@gmail.com",480,"d"));
        results.add(new resulttest("nhunguyen254@gmail.com",450,"e"));
        results.add(new resulttest("phuongthanhtran1998@gmail.com",440,"f"));
        results.add(new resulttest("phuonglynguyen2310@gmail.com",440,"g"));
        results.add(new resulttest("tonhu5498@gmail.com",420,"h"));
        results.add(new resulttest("thuyhuyen1997@gmail.com",340,"i"));
        results.add(new resulttest("minhduc2314@gmail.com",350,"k"));
        adapter = new test(getActivity(),R.layout.rowlist_chart,results);
        lvReults.setAdapter(adapter);
        /*results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");
        results.add("hung1997@gmail.com",150,"hung1997");*/
        return view;
    }
}
