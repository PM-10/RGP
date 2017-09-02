package com.pm10.rgptest.api;

import android.app.Activity;
import android.widget.Toast;

import com.pm10.rgptest.ui.base.BaseActivity;
import com.pm10.rgptest.util.ActivityUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NetworkRequest {

    //에러 핸들링
    private static Consumer<Throwable> defaultNetworkError = throwable -> {

        Activity currentActivity = ActivityUtils.getCurrentActivity();

        if (currentActivity instanceof BaseActivity)
            ((BaseActivity) currentActivity).loadingComplete();

        Toast.makeText(currentActivity, throwable.toString(), Toast.LENGTH_SHORT).show();
        throwable.printStackTrace();
    };

    public static <T> Disposable request(Observable<T> observable, Consumer<? super T> consumer) {
        return request(observable, consumer, defaultNetworkError);
    }


    public static <T> Disposable request(Observable<T> observable, Consumer<? super T> consumer, Consumer<Throwable> onError) {
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer, onError);
    }

}