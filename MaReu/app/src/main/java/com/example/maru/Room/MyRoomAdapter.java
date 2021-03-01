package com.example.maru.Room;
import android.view.LayoutInflater;;
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

import java.util.List;


public class MyRoomAdapter extends RecyclerView.Adapter<MyRoomAdapter.MyViewHolder> {

    private final List<Meeting> mMeetings;

    public MyRoomAdapter(List<Meeting> items) {
        this.mMeetings = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FragmentRoomBinding fragmentRoomBinding = FragmentRoomBinding.inflate(layoutInflater,parent,false);
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
    }




    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        FragmentRoomBinding fragmentRoomBinding;
        private TextView mNamneMeeting;
        private TextView mNamePlace;
        private ImageView mImageView;
        private TextView mHour;
        private TextView mMail;

        MyViewHolder(FragmentRoomBinding fragmentRoomBinding) {
            super(fragmentRoomBinding.getRoot());
            this.fragmentRoomBinding = fragmentRoomBinding;

            mNamneMeeting = fragmentRoomBinding.NameMeeting;
            mNamePlace= fragmentRoomBinding.Place;
            mImageView = fragmentRoomBinding.Pastille;
            mHour = fragmentRoomBinding.DateMeeting;
            mMail = fragmentRoomBinding.MailEmployer;

        }
        void display(Meeting meeting) {
            mNamneMeeting.setText(meeting.getNameMeeting());
            mNamePlace.setText(meeting.getLocalisation());
            mHour.setText(meeting.getHourMeeting());
            mImageView.setImageResource(meeting.getImageCity());
            mMail.setText(meeting.getListMail());
        }
    }

}