package com.example.maru.Room;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maru.Model.MeetingRoom;
import com.example.maru.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoomFragment extends Fragment implements View.OnClickListener {

    public RoomFragment() {
        // Required empty public constructor
    }
    private RecyclerView mRecyclerView;
    private List<MeetingRoom> mMeetingRooms;
    private RoomAdapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_room, container, false);
        ButterKnife.bind(this,view);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        this.configureRecyclerView();
        return view;
    }


    private void configureRecyclerView() {
        this.mMeetingRooms = new ArrayList<>();
        this.mAdapter = new RoomAdapter(this.mMeetingRooms);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }



    @Override
    public void onClick(View v) {

    }
}