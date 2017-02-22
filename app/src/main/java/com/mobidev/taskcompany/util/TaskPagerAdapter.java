package com.mobidev.taskcompany.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TaskPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> taskPages = new ArrayList<>();

    public TaskPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return taskPages.get(position);
    }

    @Override
    public int getCount() {
        return taskPages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return taskPages.get(position).toString();
    }

    public void addPage(Fragment fragment) {
        taskPages.add(fragment);
    }
}