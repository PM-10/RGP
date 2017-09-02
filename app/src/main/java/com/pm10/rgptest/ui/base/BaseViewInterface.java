package com.pm10.rgptest.ui.base;

import android.content.Context;
import android.content.Intent;

public interface BaseViewInterface {
    void startActivity(Intent intent);

    Context getContext();

    void loadingStart();

    void loadingComplete();
}
