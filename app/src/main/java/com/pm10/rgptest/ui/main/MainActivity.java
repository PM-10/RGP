package com.pm10.rgptest.ui.main;

import android.os.Bundle;

import com.pm10.rgptest.R;
import com.pm10.rgptest.databinding.ActivityMainBinding;
import com.pm10.rgptest.ui.base.BaseActivity;
import com.pm10.rgptest.ui.main.adapter.MainPageAdapter;
import com.pm10.rgptest.ui.main.presenter.MainContract;
import com.pm10.rgptest.ui.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> implements MainContract.RootView {

    private MainPageAdapter mainPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        presenter = new MainPresenter(this);

        mainPageAdapter = new MainPageAdapter(getSupportFragmentManager());
        presenter.setUpViewPager(binding.viewPager, mainPageAdapter, binding.tabLayout);
    }
}
