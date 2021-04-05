package com.example.maru.Service;

import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;

import java.util.ArrayList;
import java.util.List;

public class Dummy_MeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = Dummy_RoomsGenerator.generateMeeting();
    private List<MeetingRoom> rooms = Dummy_RoomsGenerator.Rooms();


    /***Generate all meeting rooms */
    @Override
    public List<Meeting> getMeetings() {
        return meetings;
    }

    /***Delete meeting room */
    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }

    /***create new meeting room */
    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    /***Generate Rooms for Creation meeting */
    public List<MeetingRoom> getRooms() {
        return rooms;
    }

    /***Filter localisation */
    @Override
    public List<Meeting> filteredByRoom(List<Meeting> meetings, String query) {
        query = query.toLowerCase();

        final List<Meeting> filteredList = new ArrayList<>();
        for (Meeting meeting : meetings) { ;
            final String text = meeting.getLocalisation().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(meeting);
            }
        }
        return filteredList;
    }

    /***filter with date */
    @Override
    public List<Meeting> filteredByDate(List<Meeting> meetings,String query) {
        query = query.toLowerCase();

        final List<Meeting> filteredList_date = new ArrayList<>();
        for (Meeting meeting : meetings) {
            final String hour = meeting.getDay().toLowerCase();
            if (hour.contains(query)) {
                filteredList_date.add(meeting);
            }
        }
        return filteredList_date;
    }



}
