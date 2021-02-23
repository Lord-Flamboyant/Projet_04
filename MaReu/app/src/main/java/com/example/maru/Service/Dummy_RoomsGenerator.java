package com.example.maru.Service;

import com.example.maru.Model.MeetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Dummy_RoomsGenerator {

    public static List<MeetingRoom> STATIC_ROOMS = Arrays.asList(
            new MeetingRoom(1,"Tokyo",3,"Tokyo","14H30","jeudi 21 Juin"),
            new MeetingRoom(2,"Kyoto",8,"Kyoto","12H20","vendredi 10 avril"),
            new MeetingRoom(3,"Osaka",5,"Osaka","09H30","lundi 12 mars"),
            new MeetingRoom(4,"Hiroshima",4,"Hiroshima","08H00","mardi 3 janvier"),
            new MeetingRoom(5,"Nagoya",10,"Nagoya","09H00","mercredi 4 janvier"),
            new MeetingRoom(6,"Yokohama",9,"Yokohama","10H00","jeudi 5 janvier"),
            new MeetingRoom(7,"Kobe",8,"Kobe","11H00","vendredi 6 janvier"),
            new MeetingRoom(8,"Sapporo",6,"Sapporo","14H30","lundi 12 avril"),
            new MeetingRoom(9,"Nara",7,"Nara","16H30","mardi 3 mai"),
            new MeetingRoom(10,"Fukuoka",5,"Fukuoka","10H30","mardi 28 mai")
    );



    static List<MeetingRoom> generateRooms() {
    return new ArrayList<>(STATIC_ROOMS);
    }
}