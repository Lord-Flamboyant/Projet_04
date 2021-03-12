package com.example.maru.View;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ListPageAdapter extends FragmentStateAdapter {


    public ListPageAdapter(FragmentActivity fa) {
        super (fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return RoomFragment.newInstance();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}