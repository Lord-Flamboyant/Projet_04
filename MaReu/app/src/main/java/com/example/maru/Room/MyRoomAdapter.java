package com.example.maru.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;

import java.util.List;

public class MyRoomAdapter extends RecyclerView.Adapter<MyRoomAdapter.MyViewHolder> {

    List<MeetingRoom> mMeetingRooms;
    public MyRoomAdapter(List<MeetingRoom> mMeetingRooms) {
        this.mMeetingRooms = mMeetingRooms;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_room,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(mMeetingRooms.get(position));
    }

    @Override
    public int getItemCount() {
        return mMeetingRooms.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mtexttest1;
        private TextView mTexttest2;

        MyViewHolder(View itemView) {
            super(itemView);

            mtexttest1 = itemView.findViewById(R.id.Name_Meeting);
            mTexttest2 = itemView.findViewById(R.id.Place);

        }
        void display(MeetingRoom meetingRoom) {
            mtexttest1.setText(meetingRoom.getNameRoom());
            mTexttest2.setText(meetingRoom.getImageCity());
        }
    }
}
