package com.example.maru.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.Main.DI;
import com.example.maru.Model.Meeting;
import com.example.maru.R;
import com.example.maru.Service.MeetingApiService;

import java.util.List;

public class RoomFragment extends Fragment {

    private MeetingApiService mMeetingApiService;
    private List<Meeting> mMeetings;
    private RecyclerView mRecyclerView;

    public static RoomFragment newInstance() {
        return new RoomFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mMeetingApiService = DI.getMeetingApiService();
        super.onCreate(savedInstanceState);
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
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        MyRoomAdapter adapter = new MyRoomAdapter(mMeetings);
        mRecyclerView.setAdapter(adapter);

        switch (id) {

            case R.id.searchee:
                item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
                return true;

            case R.id.action_search:
                SearchView searchView = (SearchView)item.getActionView();
                searchView.setQueryHint("Salle");
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        List<Meeting> filteredList = DI.getMeetingApiService().filteredByRoom(mMeetings, newText);
                        adapter.setFilter(filteredList);
                        return false;
                    }
                });
                return true;

            case R.id.search_date:

                SearchView searchView1 = (SearchView)item.getActionView();
                searchView1.setQueryHint("Date");
                searchView1.setIconified(true);
                searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        List<Meeting> filteredList = DI.getMeetingApiService().filteredByDate(mMeetings, newText);
                        adapter.setFilter(filteredList);
                        return false;
                    }
                });
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}