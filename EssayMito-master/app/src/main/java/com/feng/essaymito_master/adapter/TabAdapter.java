package com.feng.essaymito_master.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * author：feng
 * createTime: 2015/12/3
 */
public class TabAdapter extends FragmentStatePagerAdapter {
    List<Fragment> list;
    List<String> tabs;

    public TabAdapter(FragmentManager fm, List<Fragment> list, List<String> tabs) {
        super(fm);
        this.list = list;
        this.tabs = tabs;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position);
    }
}