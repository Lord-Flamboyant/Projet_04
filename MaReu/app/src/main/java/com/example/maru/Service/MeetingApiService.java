package com.example.maru.Service;

import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;

import java.util.List;

public interface MeetingApiService {

    /***Generate all meeting rooms */
    List<Meeting> getMeetings();

    /***Delete meeting room */
    void deleteMeeting(Meeting meeting);

    /***Create new meeting */
    void createMeeting(Meeting meeting);

}
