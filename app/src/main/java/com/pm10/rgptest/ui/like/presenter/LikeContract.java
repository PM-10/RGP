package com.pm10.rgptest.ui.like.presenter;

import android.support.v7.widget.RecyclerView;

import com.pm10.rgptest.ui.base.BaseViewInterface;

public interface LikeContract {
    interface RootView extends BaseViewInterface {

    }

    interface Presenter {
        void setRecyclerView(RecyclerView recyclerView);
    }
}
