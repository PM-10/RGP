package com.pm10.rgptest.ui.search.adapter;

import com.pm10.rgptest.databinding.ItemUserBinding;
import com.pm10.rgptest.db.RealmProvider;
import com.pm10.rgptest.model.User;
import com.pm10.rgptest.ui.base.BaseViewHolder;

public class SearchViewHolder extends BaseViewHolder<ItemUserBinding, User> {


    public SearchViewHolder(ItemUserBinding binding) {
        super(binding);
    }

    @Override
    public void setData(User data) {
        binding.setUser(data);
        binding.executePendingBindings();
        binding.likeButton.setOnClickListener(view -> {
            if (data.liked)
                return;

            data.liked = true;
            binding.likeButton.onClick(view);
            RealmProvider.getInstance().writeData(data);
        });
    }

}
