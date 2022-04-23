package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.FlixTRendings;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlixTrendingInterface {
    @GET("TrendingMovie")
    Call<List<FlixTRendings>> gettrending();
}
