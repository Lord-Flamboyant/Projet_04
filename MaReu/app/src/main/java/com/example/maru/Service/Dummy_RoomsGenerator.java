package com.example.maru.Service;
import com.example.maru.Model.Meeting;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Dummy_RoomsGenerator {

    public static List<MeetingRoom> STATIC_ROOMS = Arrays.asList(
            new MeetingRoom(1,"Tokyo", R.drawable.tokyo),
            new MeetingRoom(2,"Kyoto",R.drawable.kyoto),
            new MeetingRoom(3,"Osaka",R.drawable.osaka),
            new MeetingRoom(4,"Hiroshima",R.drawable.hiroshima),
            new MeetingRoom(5,"Nagoya",R.drawable.nagoya),
            new MeetingRoom(6,"Yokohama",R.drawable.yokohama),
            new MeetingRoom(7,"Kobe",R.drawable.kobe),
            new MeetingRoom(8,"Sapporo",R.drawable.sapporo),
            new MeetingRoom(9,"Nara",R.drawable.nara),
            new MeetingRoom(10,"Fukuoka",R.drawable.fukuoka)
    );

    public static List<MeetingRoom> Rooms() {
        return new ArrayList<>(STATIC_ROOMS);
    }


    public static List<Meeting> STATIC_MEETING = Arrays.asList(
            new Meeting((long) 1,"Réunion 1","15:00","2 3 2021","aleyna@gmail.com","Les poules et les oeufs","Tokyo",R.drawable.tokyo),
            new Meeting((long) 2,"Réunion 2","16:00","28 3 2021","aleyna@gmail.com, lulu@gmail.com","Prochaine réunion","Kyoto",R.drawable.kyoto),
            new Meeting((long) 3,"Réunion 3","11h:00","18 7 2021","aleyna@gmail.com, lili@gmail.com, bob@gmail.com","Test d'application","Osaka",R.drawable.osaka)
    );

    public static List<Meeting> generateMeeting() {
        return new ArrayList<> (STATIC_MEETING);
    }
}