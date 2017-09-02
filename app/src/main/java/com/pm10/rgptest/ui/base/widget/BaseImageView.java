package com.pm10.rgptest.ui.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.pm10.rgptest.util.PixelUtils;

@SuppressLint("AppCompatCustomView")
public class BaseImageView extends ImageView {
    private final String TAG = "BaseImageView";

    private Context context;

    public BaseImageView(Context context) {
        super(context);
        this.context = context;
    }

    public BaseImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public void load(String url) {
        if (TextUtils.isEmpty(url))
            return;

        try {

            post(() -> {

                int width = getMeasuredWidth();
                int height = getMeasuredHeight();
                if (width < 0 && height < 0) {
                    width = PixelUtils.getDeviceWidth(context) / 2;
                    height = PixelUtils.getDeviceHeight(context) / 2;
                }

                Glide.with(context)
                        .load(url)
                        .apply(new RequestOptions().override(width, height))
                        .transition(new DrawableTransitionOptions().crossFade(500))
                        .into(this);
            });

        } catch (Exception e) {
            Log.e(TAG, "image load exception : " + e.toString());
        }

    }
}
