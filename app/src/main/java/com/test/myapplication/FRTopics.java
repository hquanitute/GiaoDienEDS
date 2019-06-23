package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.myapplication.Adapter.TopicAdapter;
import com.test.myapplication.objects.Topic;

import java.util.ArrayList;

public class FRTopics extends Fragment {
    public FRTopics() {
    }
    GridView lvTopics;
    ArrayList<Topic> topics;
    TopicAdapter adapter;
    View view;
    String email;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private DatabaseReference mDatabase;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        email = getArguments().getString("email");
        view =inflater.inflate(R.layout.fragment_topics, container, false);
        lvTopics = view.findViewById(R.id.listviewTopics);
        lvTopics.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doChallengen(topics.get(position));
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();
        topics = new ArrayList<>();
//        topics.add(new Topic("Bài a", "Hello everybody"));
//        topics.add(new Topic("Bài 2","In the past, many such disputes have been handled through negotiation. In 1796, George Washington refused a House request for documents concerning the Jay Treaty with Britain, arguing that treaties were the sole purview of the Senate — to which he did release the papers. "));
//        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
//        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
        /*topics.add(new Topic(11,10,0," Level 11"," Knowledge", "knowledge"));
        topics.add(new Topic(12,10,0," Level 12"," Psychology", "psychology"));
        topics.add(new Topic(13,10,0," Level 13"," General ", "general"));
        topics.add(new Topic(14,10,0," Level 14"," Audition ", "audition"));
        topics.add(new Topic(15,10,0," Level 15"," Procedure ", "procedure"));
        topics.add(new Topic(16,10,0," Level 16"," Heritage", "heritage"));
        topics.add(new Topic(17,10,0," Level 17"," Schedule", "schedule"));
        topics.add(new Topic(18,10,0," Level 18"," Purpose", "purpose"));
        topics.add(new Topic(19,10,0," Level 19"," Pure", "pure"));
        topics.add(new Topic(20,10,0," Level 20"," Suggest", "suggest"));
        topics.add(new Topic(21,10,0," Level 21"," Caffeine ", "caffeine"));
        topics.add(new Topic(22,10,0," Level 22"," Chaos ", "chaos"));
        topics.add(new Topic(23,10,0," Level 23"," Choir ", "choir"));
        topics.add(new Topic(24,10,0," Level 24"," Cucumber ", "cucumber"));
        topics.add(new Topic(25,10,0," Level 25"," Cooperate ", "cooperate"));
        topics.add(new Topic(26,10,0," Level 26"," Entrepreneur ", "entrepreneur"));
        topics.add(new Topic(27,10,0," Level 27"," Foreigner ", "foreigner"));
        topics.add(new Topic(28,10,0," Level 28"," Hierarchy ", "hierarchy"));
        topics.add(new Topic(29,10,0," Level 29"," Accommodation", "accommodation"));
        topics.add(new Topic(30,10,0," Level 30"," Rhythm", "rhythm"));
//        topics.add(new Topic(3,10,0,"Lesson 3","Nice to meet you"));
       for(int i= 0 ; i< topics.size();i++){
            mDatabase.child("Topic").push().setValue(topics.get(i));
        }*/


        mDatabase.child("Topic").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    topics.add(dataSnapshot.getValue(Topic.class));
                    adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        adapter= new TopicAdapter(view.getContext(),R.layout.topic_row,topics);
        lvTopics.setAdapter(adapter);
        return view;
    }
    public void doChallengen(Topic topic){
        Intent intent = new Intent(getActivity(),Challengen.class);
        intent.putExtra("topic_name",topic.getName());
        intent.putExtra("topic_text",topic.getText());
        intent.putExtra("email",email);
        startActivity(intent);
    }

}
