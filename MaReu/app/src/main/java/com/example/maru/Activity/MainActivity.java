package com.example.maru.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.Room.MyRoomAdapter;
import com.example.maru.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    public List<MeetingRoom> mMeetingRooms;

    ActivityMainBinding activityMainBinding;
    MyRoomAdapter myRoomAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);


        mMeetingRooms = new ArrayList<>();
        mMeetingRooms.add(new MeetingRoom(9,"Nara",7,"Nara","16H30","mardi 3 mai"));
        mMeetingRooms.add(new MeetingRoom(2,"Kyoto",8,"Kyoto","12H20","vendredi 10 avril"));


        myRoomAdapter = new MyRoomAdapter(mMeetingRooms);
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