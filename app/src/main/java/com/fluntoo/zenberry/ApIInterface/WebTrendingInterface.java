package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.WebTrending;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebTrendingInterface {
    @GET("TrendingWebseries")
    Call<List<WebTrending>> gettrending();
}
