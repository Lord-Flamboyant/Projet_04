package com.example.maru.Room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter {

    public List<MeetingRoom> mMeetingRooms;

    public RoomAdapter(List<MeetingRoom> meetingRooms) {
        this.mMeetingRooms = meetingRooms;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_room,parent,false);

        return new RoomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return this.mMeetingRooms.size();
    }
}
