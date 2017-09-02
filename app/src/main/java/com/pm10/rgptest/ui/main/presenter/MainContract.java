package com.pm10.rgptest.ui.main.presenter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.pm10.rgptest.ui.base.BaseViewInterface;
import com.pm10.rgptest.ui.main.adapter.MainPageAdapter;

public interface MainContract {
    interface RootView extends BaseViewInterface {

    }

    interface Presenter {
        void setUpViewPager(ViewPager viewPager, MainPageAdapter adapter, TabLayout tabLayout);
    }
}
