package com.example.maru.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.maru.View.ListPageAdapter;
import com.example.maru.View.NewMeeting;
import com.example.maru.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        configureToolbar();

        activityMainBinding.container.setAdapter(new ListPageAdapter(this));

        activityMainBinding.buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMeeting = new Intent(MainActivity.this, NewMeeting.class);
                startActivity(newMeeting);

            }
        });
    }

    private void configureToolbar() {
        Toolbar toolbar = activityMainBinding.mytoolbar.toolBar;
        setSupportActionBar(toolbar);
    }
}

/// TODO: make responsive