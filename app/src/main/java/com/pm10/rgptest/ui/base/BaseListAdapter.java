package com.pm10.rgptest.ui.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pm10.rgptest.ui.base.listener.OnLoadMoreListener;

import java.util.ArrayList;

public abstract class BaseListAdapter<T> extends RecyclerView.Adapter {

    protected ArrayList<T> items = new ArrayList<>();

    private OnLoadMoreListener onLoadMoreListener;

    protected boolean isLoading = false;
    private boolean hasNextPage = false;
    private int itemPage = 1;

    @Override
    public int getItemCount() {
        return items.size();
    }

    public ArrayList<T> getItems() {
        return items;
    }

    protected ViewDataBinding getViewBinding(int layout, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return DataBindingUtil.inflate(inflater, layout, parent, false);
    }

    public void resetAll(ArrayList<T> items) {
        if (items == null)
            return;

        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addAll(ArrayList<T> items) {
        if (items == null)
            return;

        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void updateItem(int position) {
        notifyItemChanged(position);
    }

    protected void setLoadMore(int position) {
        if (onLoadMoreListener != null && position == getItemCount() - 1 && !isLoading && hasNextPage) {
            isLoading = true;
            itemPage++;
            onLoadMoreListener.onLoadMore(itemPage);
        }
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
        isLoading = false;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }
}
