package com.example.maru.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.maru.databinding.InformationMeetingBinding;

public class InformationMeeting extends AppCompatActivity {

    InformationMeetingBinding informationMeetingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        informationMeetingBinding = InformationMeetingBinding.inflate(getLayoutInflater());
        View view = informationMeetingBinding.getRoot();
        setContentView(view);

        //todo: joint javo to xlm
    }
}