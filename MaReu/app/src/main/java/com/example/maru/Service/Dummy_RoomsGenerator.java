package com.example.maru.Service;

import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Dummy_RoomsGenerator {

    public static List<MeetingRoom> STATIC_ROOMS = Arrays.asList(
            new MeetingRoom(1,"Tokyo",3, R.color.cTokyo),
            new MeetingRoom(2,"Kyoto",8,R.color.cKyoto),
            new MeetingRoom(3,"Osaka",5,R.color.cOsaka),
            new MeetingRoom(4,"Hiroshima",4,R.color.cHiroshima),
            new MeetingRoom(5,"Nagoya",10,R.color.cNagoya),
            new MeetingRoom(6,"Yokohama",9,R.color.cYokohama),
            new MeetingRoom(7,"Kobe",8,R.color.cKobe),
            new MeetingRoom(8,"Sapporo",6,R.color.cSapporo),
            new MeetingRoom(9,"Nara",7,R.color.cNara),
            new MeetingRoom(10,"Fukuoka",5,R.color.cFukuoka)
    );



    static List<MeetingRoom> generateRooms() {
    return new ArrayList<>(STATIC_ROOMS);
    }


    public static List<Meeting> STATIC_MEETING = Arrays.asList();


    static List<Meeting> generateMeeting() {
        return new ArrayList<Meeting> (STATIC_MEETING);
    }
}