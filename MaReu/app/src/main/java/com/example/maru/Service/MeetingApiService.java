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

    /***generate room for creating meeting */
    List<MeetingRoom> getRooms();

    /***Filter localisation */
    List<Meeting> filteredByRoom(List<Meeting> meetings, String query);

    /***filter with date */
    List<Meeting> filteredByDate(List<Meeting> meetings, String query);
}
