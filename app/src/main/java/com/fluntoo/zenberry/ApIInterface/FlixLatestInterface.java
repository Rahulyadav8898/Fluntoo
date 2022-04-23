package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.FlixLatest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlixLatestInterface {

    @GET("latestMovie")
    Call<List<FlixLatest>> getlatest();
}
