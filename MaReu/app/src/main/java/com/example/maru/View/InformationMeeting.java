package com.example.maru.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.maru.Model.Meeting;
import com.example.maru.databinding.InformationMeetingBinding;

public class InformationMeeting extends AppCompatActivity {

    InformationMeetingBinding informationMeetingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        informationMeetingBinding = InformationMeetingBinding.inflate(getLayoutInflater());
        View view = informationMeetingBinding.getRoot();
        setContentView(view);

        Intent intent = getIntent();
        Meeting meeting = intent.getParcelableExtra("id");

        informationMeetingBinding.NameMeeting.setText(meeting.getNameMeeting());
        informationMeetingBinding.DateMeetingInfo.setText(meeting.getDay());
        informationMeetingBinding.HourMeetingInfo.setText((meeting.getHourMeeting()));
        informationMeetingBinding.PlaceMeetingInfo.setText(meeting.getLocalisation());
        informationMeetingBinding.NameEmployerInfo.setText(meeting.getListMail());
        informationMeetingBinding.SujetMeetinfInfo.setText(meeting.getSujetMeeting());

    }
}