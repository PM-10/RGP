package com.pm10.rgptest.ui.main.presenter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.pm10.rgptest.ui.base.BasePresenter;
import com.pm10.rgptest.ui.main.adapter.MainPageAdapter;

public class MainPresenter extends BasePresenter<MainContract.RootView> implements MainContract.Presenter {

    public MainPresenter(MainContract.RootView view) {
        super(view);
    }


    @Override
    public void setUpViewPager(ViewPager viewPager, MainPageAdapter adapter, TabLayout tabLayout) {
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Search");
        tabLayout.getTabAt(1).setText("Like");
    }
}
