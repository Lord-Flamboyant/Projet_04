package com.example.maru.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.maru.Main.MainActivity;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;
import com.example.maru.Service.Dummy_RoomsGenerator;
import com.example.maru.databinding.MeetingNewBinding;

import java.util.List;

public class NewMeeting extends AppCompatActivity {

    MeetingNewBinding meetingNewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meetingNewBinding = MeetingNewBinding.inflate(getLayoutInflater());
        View view = meetingNewBinding.getRoot();
        setContentView(view);





        meetingNewBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewMeeting.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}