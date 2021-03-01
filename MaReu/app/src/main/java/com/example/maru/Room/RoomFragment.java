package com.example.maru.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.maru.Main.DI;
import com.example.maru.Model.DeleteMeetingEvent;
import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.example.maru.Service.MeetingApiService;
import com.example.maru.Utils.ItemClickSupport;
import com.example.maru.View.InformationMeeting;
import com.example.maru.databinding.FragmentRoomBinding;

import java.util.List;

public class RoomFragment extends Fragment {

    private MeetingApiService mMeetingApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    private Meeting mMeeting;

    FragmentRoomBinding fragmentRoomBinding;
    public static RoomFragment newInstance() {
        return new RoomFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMeetingApiService = DI.getMeetingApiService();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_room,container,false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        this.configureOnClickRecyclerView();
        return view;
    }

    private void initList() {
        mMeetings = mMeetingApiService.getMeetings();
        mRecyclerView.setAdapter(new MyRoomAdapter(mMeetings));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void configureOnClickRecyclerView() {
        ItemClickSupport.addTo(mRecyclerView,R.layout.fragment_room)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Intent intent = new Intent(getActivity(), InformationMeeting.class);
                        intent.putExtra("id",mMeetings.get(position));
                        startActivity(intent);
                    }
                });
    }
}