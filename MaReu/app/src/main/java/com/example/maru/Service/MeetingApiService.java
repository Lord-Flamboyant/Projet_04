package com.example.maru.Service;

import com.example.maru.Model.MeetingRoom;

import java.util.List;

public interface MeetingApiService {

    /***Generate all meeting rooms */
    List<MeetingRoom> getMeetingRooms();

    /***Delete meeting room */
    void deleteRoom(MeetingRoom meetingRoom);

    /***Create new meeting room */
    void createMeetingRoom(MeetingRoom meetingRoom);
}
