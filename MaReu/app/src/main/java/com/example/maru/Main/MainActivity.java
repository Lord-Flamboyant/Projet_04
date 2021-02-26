package com.example.maru.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.example.maru.Room.ListPageAdapter;
import com.example.maru.Room.MyRoomAdapter;
import com.example.maru.Room.RoomFragment;
import com.example.maru.Service.Dummy_RoomsGenerator;
import com.example.maru.View.NewMeeting;
import com.example.maru.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import static com.example.maru.Service.Dummy_RoomsGenerator.generateMeeting;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ListPageAdapter mListPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);

        mListPageAdapter = new ListPageAdapter(getSupportFragmentManager());
        activityMainBinding.container.setAdapter(mListPageAdapter);


        activityMainBinding.buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMeeting = new Intent(MainActivity.this, NewMeeting.class);
                startActivity(newMeeting);
            }
        });

    }
}