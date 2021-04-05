package com.example.maru;

import com.example.maru.Main.DI;
import com.example.maru.Model.Meeting;
import com.example.maru.Service.Dummy_RoomsGenerator;
import com.example.maru.Service.MeetingApiService;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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

    /*** Search with localisation*/
    @Test
    public void searchOsaka() {
        List<Meeting> meetingList = service.getMeetings();
        int listSizeStart = meetingList.size();
        String Localisation = "Osaka";

        List<Meeting> filteredList = DI.getMeetingApiService().filteredByRoom(meetingList, Localisation);
        filteredList.size();
        assertNotEquals(filteredList, listSizeStart);

        service.createMeeting(new Meeting((long) 1,"je pousse le bouchon ","15:00","28/3/2021","aleyna@gmail.com","j'abuse un peut","Osaka",R.drawable.tokyo));
        List<Meeting> filteredList2 = DI.getMeetingApiService().filteredByRoom(meetingList, Localisation);
        filteredList2.size();
        assertNotEquals(2, filteredList2);

    }

    /** Search with date*/
    @Test
    public void searchDate() {
        List<Meeting> meetingsList = service.getMeetings();
        int listSizeStart = meetingsList.size();
        String Date = "28";

        List<Meeting> filteredList = DI.getMeetingApiService().filteredByDate(meetingsList, Date);
        filteredList.size();
        assertNotEquals(filteredList, listSizeStart);

        service.createMeeting(new Meeting((long) 1,"je encore le bouchon","15:00","28/3/2021","aleyna@gmail.com","je suis dans l'abus","Tokyo",R.drawable.tokyo));
        List<Meeting> filteredList2 = DI.getMeetingApiService().filteredByDate(meetingsList, Date);
        filteredList2.size();
        assertNotEquals(2, filteredList2);
    }
}