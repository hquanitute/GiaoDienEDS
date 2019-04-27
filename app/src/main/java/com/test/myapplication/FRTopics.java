package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.test.myapplication.Adapter.TopicAdapter;
import com.test.myapplication.objects.Topic;

import java.util.ArrayList;

public class FRTopics extends Fragment {
    public FRTopics() {
    }
    ListView lvTopics;
    ArrayList<Topic> topics;
    TopicAdapter adapter;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_topics, container, false);
        lvTopics = view.findViewById(R.id.listviewTopics);
        lvTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doChallengen(topics.get(position));
            }
        });
        topics = new ArrayList<>();
        topics.add(new Topic("Bài 1", "Hello everybody"));
        topics.add(new Topic("Bài 2","In the past, many such disputes have been handled through negotiation. In 1796, George Washington refused a House request for documents concerning the Jay Treaty with Britain, arguing that treaties were the sole purview of the Senate — to which he did release the papers. "));
        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
         adapter= new TopicAdapter(view.getContext(),R.layout.topic_row,topics);
        lvTopics.setAdapter(adapter);
        return view;
    }
    public void doChallengen(Topic topic){
        Intent intent = new Intent(getActivity(),Challengen.class);
        intent.putExtra("topic_name",topic.getName());
        intent.putExtra("topic_text",topic.getText());
        startActivity(intent);
    }
}
