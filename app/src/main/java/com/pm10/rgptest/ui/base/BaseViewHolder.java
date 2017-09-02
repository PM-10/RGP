package com.pm10.rgptest.ui.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public abstract class BaseViewHolder<T extends ViewDataBinding, T2> extends RecyclerView.ViewHolder {

    protected T binding;

    public BaseViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public abstract void setData(T2 data);
}
