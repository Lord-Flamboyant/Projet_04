package com.example.maru;

import com.example.maru.Main.DI;
import com.example.maru.Model.Meeting;
import com.example.maru.Service.Dummy_RoomsGenerator;
import com.example.maru.Service.MeetingApiService;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {

    private MeetingApiService service;

    @Before
    public void setup() {
        service = DI.getTestMeetingApiService();
    }

    /*** create new meeting*/
    @Test
    public void createNewMeetingToList() {
        List<Meeting> meetingList = service.getMeetings();
        Meeting meeting = Dummy_RoomsGenerator.generateMeeting().get(0);
        service.createMeeting(meeting);
        assertTrue(meetingList.contains(meeting));
    }

    /*** Delete Meeting*/
    @Test
    public void deleteMeeting() {
        List<Meeting> meetingList = service.getMeetings();
        Meeting meeting = Dummy_RoomsGenerator.generateMeeting().get(0);
        service.deleteMeeting(meeting);
        assertFalse(meetingList.contains(meeting));
    }
}