package com.example.maru.Room;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ListPageAdapter extends FragmentPagerAdapter {

    public ListPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return RoomFragment.newInstance();
    }

    @Override
    public int getCount() {
        return 1;
    }


}
