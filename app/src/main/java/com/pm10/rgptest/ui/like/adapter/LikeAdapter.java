package com.pm10.rgptest.ui.like.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pm10.rgptest.R;
import com.pm10.rgptest.databinding.ItemUserBinding;
import com.pm10.rgptest.model.User;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class LikeAdapter extends RealmRecyclerViewAdapter<User, LikeViewHolder> {

    public LikeAdapter(@Nullable OrderedRealmCollection<User> data) {
        super(data.sort(User.ORDER_KEY), true);
    }

    @Override
    public LikeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_user, parent, false);
        return new LikeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(LikeViewHolder holder, int position) {
        holder.setData(getItem(position));
    }
}