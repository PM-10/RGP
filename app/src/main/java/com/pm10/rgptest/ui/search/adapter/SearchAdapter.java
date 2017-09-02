package com.pm10.rgptest.ui.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.pm10.rgptest.R;
import com.pm10.rgptest.databinding.ItemUserBinding;
import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BaseListAdapter;

public class SearchAdapter extends BaseListAdapter<User> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchViewHolder((ItemUserBinding) getViewBinding(R.layout.item_user, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        setLoadMore(position);
        SearchViewHolder searchViewHolder = (SearchViewHolder) holder;
        searchViewHolder.setData(items.get(position));
    }
}
