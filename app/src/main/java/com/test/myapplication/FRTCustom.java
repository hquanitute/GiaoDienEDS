package com.test.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.test.myapplication.Adapter.TopicAdapter;
import com.test.myapplication.objects.Topic;

import java.util.ArrayList;

public class FRTCustom extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topics,container,false);
        ListView listView = view.findViewById(R.id.listviewTopics);
        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(new Topic("Custom1","Customadadadadad"));
        TopicAdapter topicAdapter = new TopicAdapter(view.getContext(),R.layout.topic_row,topics);
        listView.setAdapter(topicAdapter);
        return view;
    }
}
