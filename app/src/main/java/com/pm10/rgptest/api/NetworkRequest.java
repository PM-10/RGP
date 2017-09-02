package com.pm10.rgptest.api;

import com.pm10.rgptest.util.ErrorUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class NetworkRequest {

    //에러 핸들링
    private static Consumer<Throwable> defaultNetworkError = throwable -> {
        ErrorUtils.showErrorToast(throwable);
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