package com.example.maru.Service;

import com.example.maru.Model.MeetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Dummy_RoomsGenerator {

    public static List<MeetingRoom> STATIC_ROOMS = Arrays.asList(
            new MeetingRoom(1,"Tokyo",3,"tokyo"),
            new MeetingRoom(2,"Kyoto",8,"Kyoto"),
            new MeetingRoom(3,"Osaka",5,"Osaka"),
            new MeetingRoom(4,"Hiroshima",4,"Hiroshima"),
            new MeetingRoom(5,"Nagoya",10,"Nagoya"),
            new MeetingRoom(6,"Yokohama",9,"Yokohama"),
            new MeetingRoom(7,"Kobe",8,"Kobe"),
            new MeetingRoom(8,"Sapporo",6,"Sapporo"),
            new MeetingRoom(9,"Nara",7,"Nara"),
            new MeetingRoom(10,"Fukuoka",5,"Fukuoka")
    );



    static List<MeetingRoom> generateRooms() {
    return new ArrayList<>(STATIC_ROOMS);
    }
}