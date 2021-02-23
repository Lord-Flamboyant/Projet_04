package com.example.maru.Room;
import android.view.LayoutInflater;;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.maru.Model.MeetingRoom;
import com.example.maru.databinding.FragmentRoomBinding;
import java.util.List;


public class MyRoomAdapter extends RecyclerView.Adapter<MyRoomAdapter.MyViewHolder> {

    List<MeetingRoom> mMeetingRooms;

    public MyRoomAdapter(List<MeetingRoom> mMeetingRooms) {
        this.mMeetingRooms = mMeetingRooms;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        FragmentRoomBinding fragmentRoomBinding = FragmentRoomBinding.inflate(layoutInflater,parent,false);
        return new MyViewHolder(fragmentRoomBinding);
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

        FragmentRoomBinding fragmentRoomBinding;
        private TextView mNamneMeeting;
        private TextView mNamePlace;


        MyViewHolder(FragmentRoomBinding fragmentRoomBinding) {
            super(fragmentRoomBinding.getRoot());
            this.fragmentRoomBinding = fragmentRoomBinding;

            mNamneMeeting = fragmentRoomBinding.NameMeeting;
            mNamePlace= fragmentRoomBinding.Place;

        }
        void display(MeetingRoom meetingRoom) {
            mNamneMeeting.setText(meetingRoom.getNameRoom());
            mNamePlace.setText(meetingRoom.getImageCity());
        }

    }
}
