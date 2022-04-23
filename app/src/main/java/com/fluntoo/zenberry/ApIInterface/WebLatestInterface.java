package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.LatestWeb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebLatestInterface {
    @GET("latestWebSeries")
    Call<List<LatestWeb>> getlatest();


}
