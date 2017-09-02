package com.pm10.rgptest.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pm10.rgptest.R;
import com.pm10.rgptest.databinding.FragmentSearchBinding;
import com.pm10.rgptest.event.UnLikedEvent;
import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BaseFragment;
import com.pm10.rgptest.ui.search.adapter.SearchAdapter;
import com.pm10.rgptest.ui.search.presenter.SearchContract;
import com.pm10.rgptest.ui.search.presenter.SearchPresenter;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchPresenter> implements SearchContract.RootView {

    private SearchAdapter searchAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return createView(inflater, R.layout.fragment_search);
    }


    @Override
    protected void init() {
        presenter = new SearchPresenter(this);

        searchAdapter = new SearchAdapter();

        presenter.setUpInput(binding.inputView, binding.searchButton);
        presenter.setUpRecyclerView(binding.recyclerView, searchAdapter);
    }

    private void scrollToTop() {
        binding.recyclerView.post(() -> {
            binding.recyclerView.scrollToPosition(0);
        });
    }

    @Override
    public void resetList(ArrayList<User> list, boolean hasNext) {
        searchAdapter.resetAll(list);
        searchAdapter.setHasNextPage(hasNext);
        scrollToTop();
    }

    @Override
    public void addList(ArrayList<User> list, boolean hasNext) {
        searchAdapter.addAll(list);
        searchAdapter.setHasNextPage(hasNext);
    }

    @Override
    public void updateUser(int position) {
        searchAdapter.updateItem(position);
    }

    @Override
    public void updateTotalCount(int count) {
        binding.totalCountView.setText(count + " results");
    }

    @Subscribe
    public void unLikedEvent(UnLikedEvent event) {
        presenter.unLikeUser(searchAdapter.getItems(), event.id);
    }
}
