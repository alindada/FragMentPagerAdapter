package com.example.administrator.fragmentpageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;

import java.util.List;

/**
 * Created by Administrator on 2018/1/24.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    //private List<Fragment> mFragments;
    private SparseArray<Fragment> mFragments;

    public  MainAdapter(FragmentManager manager ,SparseArray<Fragment> fragments){
        super(manager);
        mFragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
       return mFragments.get(position);
       // return MainFlagment.getMainFlagment(String.valueOf(position));
    }


    @Override
    public int getCount() {
        return mFragments.size();
    }
}
