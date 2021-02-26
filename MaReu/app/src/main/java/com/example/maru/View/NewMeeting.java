package com.example.maru.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.example.maru.Main.DI;
import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;
import com.example.maru.Service.MeetingApiService;
import com.example.maru.databinding.MeetingNewBinding;
import static com.example.maru.R.layout.support_simple_spinner_dropdown_item;

public class NewMeeting extends AppCompatActivity {

    MeetingNewBinding meetingNewBinding;
    private MeetingApiService meetingApiService;
    MeetingRoom mMeetingRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meetingNewBinding = MeetingNewBinding.inflate(getLayoutInflater());
        View view = meetingNewBinding.getRoot();
        setContentView(view);
        meetingApiService = DI.getMeetingApiService();

        /***Creation spinner*/
        String[] rooms = {"Tokyo","osaka"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, support_simple_spinner_dropdown_item,rooms);
        meetingNewBinding.LocalisationNew.setAdapter(adapter);



        /***Creation new Meeting*/
        meetingNewBinding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Meeting meeting = new Meeting(
                        System.currentTimeMillis(),
                        meetingNewBinding.NameMeetingNew.getEditableText().toString(),
                        meetingNewBinding.HourMeetingNew.getEditableText().toString(),
                        meetingNewBinding.DateMeetingNew.getEditableText().toString(),
                        meetingNewBinding.MailMeetinNew.getEditableText().toString(),
                        meetingNewBinding.SujetMeetingNew.getEditableText().toString(),
                        "Tokyo",
                        R.color.cTokyo

                );
                meetingApiService.createMeeting(meeting);
                finish();
            }
        });
    }
}