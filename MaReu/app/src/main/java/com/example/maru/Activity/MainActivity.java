package com.example.maru.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;
import com.example.maru.Room.MyRoomAdapter;
import com.example.maru.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    public List<Meeting> mMeetings;

    ActivityMainBinding activityMainBinding;
    MyRoomAdapter myRoomAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);


        mMeetings = new ArrayList<>();
        mMeetings.add(new Meeting("Reunion",1,"15h00","Lundi","aleyna@gmail.com","","Tokyo",R.color.cTokyo));

        myRoomAdapter = new MyRoomAdapter(mMeetings);
        mRecyclerView = activityMainBinding.ListRoom1;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myRoomAdapter);

        activityMainBinding.buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}