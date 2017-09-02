package com.pm10.rgptest.api;

import com.pm10.rgptest.model.GitResult;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitApiInterface {

    @GET("search/users")
    Observable<Response<GitResult>> getUsers(@Query("page") int page, @Query("q") String q);

}
