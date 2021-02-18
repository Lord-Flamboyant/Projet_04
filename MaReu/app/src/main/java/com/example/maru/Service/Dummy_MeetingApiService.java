package com.example.maru.Service;

import com.example.maru.Model.MeetingRoom;

import java.util.List;

public class Dummy_MeetingApiService implements MeetingApiService {

    private List<MeetingRoom> meetingRooms = Dummy_RoomsGenerator.generateRooms();


    /***Generate all meeting rooms */
    @Override
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }

    /***Delete meeting room */
    @Override
    public void deleteRoom(MeetingRoom meetingRoom) {
        meetingRooms.remove(meetingRoom);
    }

    /***create new meeting room */
    @Override
    public void createMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }
}
