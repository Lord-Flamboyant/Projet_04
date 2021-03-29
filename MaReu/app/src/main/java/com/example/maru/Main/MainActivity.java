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

    ActivityMainBinding binding;
    ListPageAdapter mListPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configureToolbar();

        mListPageAdapter = new ListPageAdapter(this);
        binding.viewmeeting.setAdapter(mListPageAdapter);

        binding.buttonAddMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newMeeting = new Intent(MainActivity.this, NewMeeting.class);
                startActivity(newMeeting);

            }
        });
    }

    private void configureToolbar() {
        Toolbar toolbar = binding.mytoolbar.toolBar;
        setSupportActionBar(toolbar);
    }
}