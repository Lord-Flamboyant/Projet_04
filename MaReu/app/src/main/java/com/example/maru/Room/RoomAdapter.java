package com.example.maru.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {


    List<MeetingRoom> mMeetingRooms;

    public RoomAdapter(List<MeetingRoom> Rooms) {
        this.mMeetingRooms = Rooms;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_room,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(mMeetingRooms.get(position));
    }

    @Override
    public int getItemCount() {
        return mMeetingRooms.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mPastille;
        TextView mName_Meeting;
        TextView mDate_Meeting;
        TextView mLocation;
        TextView mMail_Employer;
        ImageButton mTrash_Can;


        public MyViewHolder( View itemView) {
            super(itemView);
            mPastille = itemView.findViewById(R.id.Pastille);
            mName_Meeting = itemView.findViewById(R.id.Name_Meeting);
            mDate_Meeting = itemView.findViewById(R.id.Date_Meeting);
            mLocation = itemView.findViewById(R.id.Place);
            mMail_Employer = itemView.findViewById(R.id.Mail_employer);
            mTrash_Can = itemView.findViewById(R.id.Trash_can);
        }

        void display(MeetingRoom meetingRoom) {
            mName_Meeting.setText("rendez-vous" );
            mDate_Meeting.setText("16" +1);
            mLocation.setText(meetingRoom.getNameRoom());
            mMail_Employer.setText("brigite roger bob ");

        }
    }
}
