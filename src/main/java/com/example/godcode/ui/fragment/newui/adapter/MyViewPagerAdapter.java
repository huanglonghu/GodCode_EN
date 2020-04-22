package com.example.godcode.ui.fragment.newui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.godcode.ui.base.BaseFragment;
import java.util.ArrayList;


public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> fragments=new ArrayList<>();
    public MyViewPagerAdapter(FragmentManager fm,ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
