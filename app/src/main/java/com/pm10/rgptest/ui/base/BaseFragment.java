package com.pm10.rgptest.ui.base;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.pm10.rgptest.event.BusProvider;

public abstract class BaseFragment<T extends ViewDataBinding, T2 extends BasePresenter> extends Fragment implements BaseViewInterface {

    protected T binding;
    protected T2 presenter;
    protected Context context;


    protected View createView(LayoutInflater inflater, int layoutResourceId) {
        View view = inflater.inflate(layoutResourceId, null);
        binding = DataBindingUtil.bind(view);
        context = getContext();
        init();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void loadingStart() {
        Activity activity = getActivity();
        if (activity instanceof BaseActivity)
            ((BaseActivity) activity).loadingStart();
    }

    @Override
    public void loadingComplete() {
        Activity activity = getActivity();
        if (activity instanceof BaseActivity)
            ((BaseActivity) activity).loadingComplete();
    }

    protected abstract void init();
}