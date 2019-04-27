package com.test.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.myapplication.Adapter.TopicAdapter;
import com.test.myapplication.objects.Topic;

import java.util.ArrayList;

public class FRTopics extends Fragment {
    public FRTopics() {
    }
    ListView lvTopics;
    ArrayList<Topic> topics;
    TopicAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_topics, container, false);
        lvTopics = view.findViewById(R.id.listviewTopics);
        topics = new ArrayList<>();
        topics.add(new Topic("Bài 1", "Hello everybody"));
        topics.add(new Topic("Bài 2","My name is Hoang Quan adad adad adad adad adad dad adadad adada dada dada "));
        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
         adapter= new TopicAdapter(view.getContext(),R.layout.topic_row,topics);
        lvTopics.setAdapter(adapter);
        return view;
    }

}
