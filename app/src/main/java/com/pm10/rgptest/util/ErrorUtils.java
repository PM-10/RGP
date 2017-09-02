package com.pm10.rgptest.util;

import android.app.Activity;
import android.widget.Toast;

import com.pm10.rgptest.ui.base.BaseActivity;

public class ErrorUtils {
    public static void showErrorToast(Throwable throwable){
        Activity currentActivity = ActivityUtils.getCurrentActivity();

        if (currentActivity instanceof BaseActivity)
            ((BaseActivity) currentActivity).loadingComplete();

        Toast.makeText(currentActivity, throwable.toString(), Toast.LENGTH_SHORT).show();
        throwable.printStackTrace();
    }
}
