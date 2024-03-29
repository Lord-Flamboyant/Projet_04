package com.example.maru.View;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.maru.Main.DI;
import com.example.maru.Model.Meeting;
import com.example.maru.databinding.FragmentRoomBinding;

import java.util.ArrayList;
import java.util.List;

public class MyRoomAdapter extends RecyclerView.Adapter<MyRoomAdapter.MyViewHolder> {

    List<Meeting> mMeetings;
    List<Meeting> mFullMeetings;

    public MyRoomAdapter(List<Meeting> items) {
        this.mMeetings = items;
        mFullMeetings = new ArrayList<>(items);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FragmentRoomBinding fragmentRoomBinding = FragmentRoomBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(fragmentRoomBinding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.display(mMeetings.get(position));
        Glide.with(holder.mImageView.getContext())
                .load(mMeetings.get(position).getImageCity())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mImageView);

        holder.fragmentRoomBinding.TrashCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DI.getMeetingApiService().deleteMeeting(mMeetings.remove(position));
                notifyDataSetChanged();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(v.getContext(), InformationMeeting.class);
                intent.putExtra("id", (mMeetings.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        FragmentRoomBinding fragmentRoomBinding;
        private final TextView mNamneMeeting;
        private final TextView mNamePlace;
        private final ImageView mImageView;
        private final TextView mHour;
        private final TextView mMail;
        private ImageView mTrash;

        MyViewHolder(FragmentRoomBinding fragmentRoomBinding) {
            super(fragmentRoomBinding.getRoot());
            this.fragmentRoomBinding = fragmentRoomBinding;

            mNamneMeeting = fragmentRoomBinding.NameMeeting;
            mNamePlace = fragmentRoomBinding.Place;
            mImageView = fragmentRoomBinding.Pastille;
            mHour = fragmentRoomBinding.DateMeeting;
            mMail = fragmentRoomBinding.MailEmployer;
            mTrash = fragmentRoomBinding.TrashCan;
        }

        void display(Meeting meeting) {
            mNamneMeeting.setText(meeting.getNameMeeting());
            mNamePlace.setText(meeting.getLocalisation());
            mHour.setText(meeting.getHourMeeting());
            mImageView.setImageResource(meeting.getImageCity());
            mMail.setText(meeting.getListMail());
        }
    }

    /***search*/
    public void setFilter(List<Meeting> meetings) {
        mMeetings = new ArrayList<>();
        mMeetings.addAll(meetings);
        notifyDataSetChanged();
    }

}

