package com.example.maru.Main;

import com.example.maru.Service.Dummy_MeetingApiService;
import com.example.maru.Service.MeetingApiService;

public class DI {

    private static MeetingApiService service = new Dummy_MeetingApiService();

    /***Instance MeetingApiService */
    public static MeetingApiService getMeetingApiService() {
        return service;
    }

}
