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
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.test.myapplication.Adapter.ChallengeAdapter;
import com.test.myapplication.Adapter.TopicAdapter;
import com.test.myapplication.objects.Result;
import com.test.myapplication.objects.Topic;

import java.io.Serializable;
import java.util.ArrayList;

public class FRTCustom extends Fragment {
    ListView lvReults;
    ArrayList<Result> results;
    ChallengeAdapter adapter;
    View view;
    String email;
    private DatabaseReference mDatabase;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        email = getArguments().getString("email");
        View view = inflater.inflate(R.layout.fragment_topics,container,false);
        lvReults = view.findViewById(R.id.listviewTopics); // su dung lai fragment
        lvReults.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(results.get(position).getPointEnemy()==0.0&&results.get(position).getIdEnemy().equals(email)){
                    //Toast.makeText(getContext(), "Ko thể thi", Toast.LENGTH_SHORT).show();
                    repChallengen(results.get(position));
                }
                else {
                    //Toast.makeText(getContext(), "Có thể thi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mDatabase = FirebaseDatabase.getInstance().getReference();
        results = new ArrayList<>();
//        topics.add(new Topic("Bài 1", "Hello everybody"));
//        topics.add(new Topic("Bài 2","In the past, many such disputes have been handled through negotiation. In 1796, George Washington refused a House request for documents concerning the Jay Treaty with Britain, arguing that treaties were the sole purview of the Senate — to which he did release the papers. "));
//        topics.add(new Topic("Bài 2","My name is Hoang Quan"));
//        topics.add(new Topic("Bài 2","My name is Hoang Quan"));

//        topics.add(new Topic(1,5,0,"Lesson 1","Hello everone , my name is Hoang Quan"));
//        topics.add(new Topic(3,10,0,"Lesson 3","Nice to meet you"));
//        for(int i= 0 ; i< topics.size();i++){
//            mDatabase.child("Topic").push().setValue(topics.get(i));
//        }

        //results.add(new Result( 1, "hung@gmail.com", "quan@gmail.com",  "Lesson 1", 10.0, 5.0));
        for(int i= 0 ; i< results.size();i++){
            mDatabase.child("Result").push().setValue(results.get(i));
        }

        mDatabase.child("Result").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                results.add(dataSnapshot.getValue(Result.class));
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
        adapter= new ChallengeAdapter(view.getContext(),R.layout.challenge_row,results);
        lvReults.setAdapter(adapter);
        return view;
    }
    public void repChallengen(Result result){
        Intent intent = new Intent(getActivity(),Challengen.class);
        intent.putExtra("topic_name",result.getIdTopic());
        intent.putExtra("topic_text",result.getTextResult());
        intent.putExtra("email",email);
        intent.putExtra("flag",1);  // Bien co so với send khác với rep Challenge
        intent.putExtra("id",result.getId());
        Bundle bundle = new Bundle();
        bundle.putSerializable("result", (Serializable) result);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
