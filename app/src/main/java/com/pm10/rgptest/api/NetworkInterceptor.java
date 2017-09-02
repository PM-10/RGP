package com.pm10.rgptest.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {

    private final String GIT_HUB_TOKEN = "250a3878d339053fddd84ba26722678a099e2ff9";

    @Override
    public Response intercept(Chain chain) throws IOException {
        try {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "token " + GIT_HUB_TOKEN)
                    .build();

            return chain.proceed(newRequest);

        } catch (Exception e) {
            e.printStackTrace();
            return chain.proceed(chain.request());
        }
    }
}
