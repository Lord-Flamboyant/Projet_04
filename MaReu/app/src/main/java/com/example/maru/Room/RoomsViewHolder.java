package com.example.maru.Room;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoomsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.Place)
    TextView mTextView;


    public RoomsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateList(MeetingRoom meetingRoom) {
        this.mTextView.setText(meetingRoom.getNameRoom());
    }
}
