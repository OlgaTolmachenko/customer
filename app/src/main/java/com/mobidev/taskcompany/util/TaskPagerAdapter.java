package com.mobidev.taskcompany.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

<<<<<<< HEAD
<<<<<<< HEAD
public class TaskPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> taskPages = new ArrayList<>();
=======
/**
 * Created by Olga Tolmachenko on 23.01.17.
 */

=======
>>>>>>> 3497b4d... refactoring
public class TaskPagerAdapter extends FragmentStatePagerAdapter {

<<<<<<< HEAD
    ArrayList<Fragment> taskPages = new ArrayList<>();
>>>>>>> dabb3d3... Implement taskpager fragments
=======
    private ArrayList<Fragment> taskPages = new ArrayList<>();
>>>>>>> 64f37b7... Add progressBars

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
