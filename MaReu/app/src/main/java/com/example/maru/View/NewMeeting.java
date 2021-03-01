package com.example.maru.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TimePicker;
import com.example.maru.Main.DI;
import com.example.maru.Main.MainActivity;
import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;
import com.example.maru.Service.Dummy_RoomsGenerator;
import com.example.maru.Service.MeetingApiService;
import com.example.maru.databinding.MeetingNewBinding;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewMeeting extends AppCompatActivity {

    MeetingNewBinding meetingNewBinding;
    List<MeetingRoom> mMeetingRooms;
    private MeetingApiService meetingApiService;
    int mhour, mminute;
    Calendar mCalendar = Calendar.getInstance();
    int day = mCalendar.get(Calendar.DAY_OF_MONTH);
    int month = mCalendar.get(Calendar.MONTH);
    int year = mCalendar.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meetingNewBinding = MeetingNewBinding.inflate(getLayoutInflater());
        View view = meetingNewBinding.getRoot();
        setContentView(view);
        meetingApiService = DI.getMeetingApiService();
        configureToolbar();

        /***Creation spinner*/
        List<MeetingRoom> meetingRoom = Dummy_RoomsGenerator.Rooms();
        this.mMeetingRooms = Dummy_RoomsGenerator.STATIC_ROOMS;
        ArrayAdapter<MeetingRoom> adapter = new ArrayAdapter<MeetingRoom>(this, android.R.layout.simple_spinner_item,mMeetingRooms);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.meetingNewBinding.LocalisationNew.setAdapter(adapter);
        this.meetingNewBinding.LocalisationNew.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onItemSelectedHandler(parent, view, position, id);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
            private void onItemSelectedHandler(AdapterView<?> adapterView, View view, int position, long id) {
                Adapter adapter = adapterView.getAdapter();
                MeetingRoom meetingRoom= (MeetingRoom) adapter.getItem(position);}
        });

        /***Hour select*/
        meetingNewBinding.HourMeetingNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timerPikerDialog = new TimePickerDialog(
                        NewMeeting.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view,int hourOfDay, int minute) {
                                mhour = hourOfDay;
                                mminute = minute;
                                String time = mhour + ":" + mminute;
                                @SuppressLint("SimpleDateFormat") SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    @SuppressLint("SimpleDateFormat") SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    meetingNewBinding.HourMeetingNew.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0,false
                );
                timerPikerDialog.updateTime(mhour,mminute);
                timerPikerDialog.show();
            }
        });

        /***Day Selecteur */
        meetingNewBinding.DateMeetingNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        NewMeeting.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,int month, int dayOfMonth) {
                                meetingNewBinding.DateMeetingNew.setText(dayOfMonth+ " " + month + " " +year);
                            }
                        },year,month,day);
                datePickerDialog.show();
            }
        });

        /***Creation new Meeting*/
        meetingNewBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meeting meeting = new Meeting(
                        System.currentTimeMillis(),
                        meetingNewBinding.NameMeetingNew.getEditableText().toString(),
                        meetingNewBinding.HourMeetingNew.getText().toString(),
                        meetingNewBinding.DateMeetingNew.getText().toString(),
                        meetingNewBinding.MailMeetinNew.getEditableText().toString(),
                        meetingNewBinding.SujetMeetingNew.getEditableText().toString(),
                        meetingNewBinding.LocalisationNew.getSelectedItem().toString(),
                        meetingNewBinding.LocalisationNew.getSelectedItem().hashCode()
                );
                meetingApiService.createMeeting(meeting);
                finish();
            }
        });
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
                Intent back = new Intent(NewMeeting.this, MainActivity.class);
                startActivity(back);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void configureToolbar() {
        Toolbar toolbar = meetingNewBinding.mytoolbarnew.toolbar;
        setSupportActionBar(toolbar);
    }
}