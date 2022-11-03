package com.example.plasmacollection;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerAdapterForServices extends FragmentPagerAdapter {
    public viewPagerAdapterForServices(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return new HospitalNearby();
        }
        else if (position == 1)
        {
            return new ViewRequests();
        }
        else
        {
            return new BecomeDonor();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
