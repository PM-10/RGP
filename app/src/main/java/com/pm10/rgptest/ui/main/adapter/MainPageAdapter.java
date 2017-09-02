package com.pm10.rgptest.ui.main.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pm10.rgptest.ui.like.LikeFragment;
import com.pm10.rgptest.ui.search.SearchFragment;

public class MainPageAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 2;

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new SearchFragment();
                break;
            case 1:
                fragment = new LikeFragment();
                break;
            default:
                new NullPointerException("포지션 값이 잘못되었습니다.");
                return null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
