package com.example.maru.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.maru.Model.Meeting;
import com.example.maru.Room.MyRoomAdapter;
import com.example.maru.View.NewMeeting;
import com.example.maru.databinding.ActivityMainBinding;
import java.util.List;

import static com.example.maru.Service.Dummy_RoomsGenerator.generateMeeting;

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

        mMeetings = generateMeeting();

        myRoomAdapter = new MyRoomAdapter(mMeetings);
        mRecyclerView = activityMainBinding.ListRoom1;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(myRoomAdapter);

        activityMainBinding.buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMeeting = new Intent(MainActivity.this, NewMeeting.class);
                startActivity(newMeeting);
            }
        });

    }
}