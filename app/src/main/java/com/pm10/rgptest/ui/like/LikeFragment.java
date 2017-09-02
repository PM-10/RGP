package com.pm10.rgptest.ui.like;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pm10.rgptest.R;
import com.pm10.rgptest.databinding.FragmentLikeBinding;
import com.pm10.rgptest.ui.base.BaseFragment;
import com.pm10.rgptest.ui.like.presenter.LikeContract;
import com.pm10.rgptest.ui.like.presenter.LikePresenter;
import com.pm10.rgptest.util.KeyboardUtils;

public class LikeFragment extends BaseFragment<FragmentLikeBinding, LikePresenter> implements LikeContract.RootView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView(inflater, R.layout.fragment_like);
    }

    @Override
    protected void init() {
        presenter = new LikePresenter(this);

        presenter.setRecyclerView(binding.recyclerView);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser)
            KeyboardUtils.hideKeyboard();
    }
}
