package com.pm10.rgptest.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static final String BASE_URL = "https://api.github.com/";

    private static GitApiInterface apiService;

    public static GitApiInterface getService() {
        if (apiService == null) {
            apiService = setApiService();
        }
        return apiService;
    }

    private static GitApiInterface setApiService() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.interceptors().add(httpLoggingInterceptor);
        builder.interceptors().add(new NetworkInterceptor());
        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(GitApiInterface.class);
    }

}