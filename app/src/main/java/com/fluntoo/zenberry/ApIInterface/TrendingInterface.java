package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Trending;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrendingInterface {
    @GET("trending1")
    Call<List<Trending>> gettrending();
}
