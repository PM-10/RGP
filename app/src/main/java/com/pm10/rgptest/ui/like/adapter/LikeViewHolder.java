package com.pm10.rgptest.ui.like.adapter;

import com.pm10.rgptest.databinding.ItemUserBinding;
import com.pm10.rgptest.db.RealmProvider;
import com.pm10.rgptest.event.BusProvider;
import com.pm10.rgptest.event.UnLikedEvent;
import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BaseViewHolder;

public class LikeViewHolder extends BaseViewHolder<ItemUserBinding, User> {


    public LikeViewHolder(ItemUserBinding binding) {
        super(binding);
    }

    @Override
    public void setData(User data) {
        binding.setUser(data);
        binding.likeButton.setOnClickListener(view -> {
            BusProvider.getInstance().post(new UnLikedEvent(data.id));
            RealmProvider.getInstance().deleteData(User.class, User.PRIMARY_KEY, data.id);
            view.setOnClickListener(null);
        });
    }

}