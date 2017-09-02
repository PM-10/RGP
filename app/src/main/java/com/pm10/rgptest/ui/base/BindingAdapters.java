package com.pm10.rgptest.ui.base;

import android.databinding.BindingAdapter;

import com.pm10.rgptest.ui.base.widget.BaseImageView;

public class BindingAdapters {

    @BindingAdapter("loadImage")
    public static void loadImage(BaseImageView imageView, String url) {
        imageView.setImageDrawable(null);
        imageView.load(url);
    }
}
