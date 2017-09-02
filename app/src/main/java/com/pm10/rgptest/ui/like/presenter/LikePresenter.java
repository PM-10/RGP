package com.pm10.rgptest.ui.like.presenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pm10.rgptest.db.RealmProvider;
import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BasePresenter;
import com.pm10.rgptest.ui.like.adapter.LikeAdapter;

public class LikePresenter extends BasePresenter<LikeContract.RootView> implements LikeContract.Presenter {

    public LikePresenter(LikeContract.RootView view) {
        super(view);
    }

    @Override
    public void setRecyclerView(RecyclerView recyclerView) {
        LikeAdapter adapter = new LikeAdapter(
                RealmProvider.getInstance().findAllData(User.class));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }
}
