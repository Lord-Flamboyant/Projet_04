package com.example.maru.Model;

public class DeleteMeetingEvent {

    public Meeting mMeeting;

    public DeleteMeetingEvent(Meeting meeting) {
        this.mMeeting = meeting;
    }
}
