package com.example.maru.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.maru.Main.MainActivity;
import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.example.maru.databinding.InformationMeetingBinding;

public class InformationMeeting extends AppCompatActivity {

    InformationMeetingBinding informationMeetingBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        informationMeetingBinding = InformationMeetingBinding.inflate(getLayoutInflater());
        View view = informationMeetingBinding.getRoot();
        setContentView(view);
        configureToolbar();

        Intent intent = getIntent();
        Meeting meeting = intent.getParcelableExtra("id");

        informationMeetingBinding.NameMeeting.setText(meeting.getNameMeeting());
        informationMeetingBinding.DateMeetingInfo.setText(meeting.getDay());
        informationMeetingBinding.HourMeetingInfo.setText(meeting.getHourMeeting());
        informationMeetingBinding.PlaceMeetingInfo.setText(meeting.getLocalisation());
        informationMeetingBinding.NameEmployerInfo.setText(meeting.getListMail());
        informationMeetingBinding.SujetMeetinfInfo.setText(meeting.getSujetMeeting());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.information_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:
                Intent back = new Intent(InformationMeeting.this, MainActivity.class);
                startActivity(back);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void configureToolbar() {
        Toolbar toolbar = informationMeetingBinding.mytoolbarinfo.toolBar;
        setSupportActionBar(toolbar);

    }
}