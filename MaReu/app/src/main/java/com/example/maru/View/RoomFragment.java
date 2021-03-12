package com.example.maru.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Main.DI;
import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.example.maru.Service.MeetingApiService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RoomFragment extends Fragment {

    private MeetingApiService mMeetingApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int month = calendar.get(Calendar.MONTH);
    int year =calendar.get(Calendar.YEAR);

    public static RoomFragment newInstance() {
        return new RoomFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        mMeetingApiService = DI.getMeetingApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_room, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
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


    /*** search with localisation*/
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Salle");

        MyRoomAdapter adapter = new MyRoomAdapter(mMeetings);
        mRecyclerView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Meeting> filteredList = filter(mMeetings, newText);
                adapter.setFilter(filteredList);

                return false;
            }
        });


        MenuItem searchDate = menu.findItem(R.id.search_date);
        SearchView searchView1 = (SearchView) searchDate.getActionView();
        searchView1.setQueryHint("date");

        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<Meeting> filteredList = filter_date(mMeetings, newText);
                adapter.setFilter(filteredList);
                return false;
            }
        });

        super.onCreateOptionsMenu(menu,inflater);
    }

    /***filter*/
    private List<Meeting> filter(List<Meeting> meetings,String query) {
        query = query.toLowerCase();

        final List<Meeting> filteredList = new ArrayList<>();
        for (Meeting meeting : meetings) { ;
            final String text = meeting.getLocalisation().toLowerCase();
            if (text.contains(query)) {
                filteredList.add(meeting);
            }
        }
        return filteredList;
    }

    private List<Meeting> filter_date(List<Meeting> meetings,String query) {
        query = query.toLowerCase();

        final List<Meeting> filteredList_date = new ArrayList<>();
        for (Meeting meeting : meetings) {
            final String hour = meeting.getDay().toLowerCase();
            if (hour.contains(query)) {
                filteredList_date.add(meeting);
            }
        }
        return filteredList_date;
    }
}