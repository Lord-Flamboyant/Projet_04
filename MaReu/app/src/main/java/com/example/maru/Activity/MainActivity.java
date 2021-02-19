package com.example.maru.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;
import com.example.maru.Room.MyRoomAdapter;
import com.example.maru.Room.RoomAdapter;
import com.example.maru.Service.Dummy_RoomsGenerator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    public List<MeetingRoom> mMeetingRooms;
    public MyRoomAdapter mRoomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.List_Room1);

        mMeetingRooms = new ArrayList<>();
        mMeetingRooms.add(new MeetingRoom(1,"Ma reunion",3,"tokyo"));
        mMeetingRooms.add(new MeetingRoom(1,"les news",7,"yokohama"));

        mRoomAdapter = new MyRoomAdapter(mMeetingRooms);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(mRoomAdapter);

    }
}