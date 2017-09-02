package com.pm10.rgptest.ui.base;

public class BasePresenter<T> {

    protected T rootView;

    public BasePresenter(T view) {
        rootView = view;
    }

}

