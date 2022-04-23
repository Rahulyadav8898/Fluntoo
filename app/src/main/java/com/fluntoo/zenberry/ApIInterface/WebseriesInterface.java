package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.WebEpisodes;
import com.fluntoo.zenberry.Model.WebSeasons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebseriesInterface {
    @GET
    Call<List<WebSeasons>> getseason(@Url String url);


    @GET
    Call<List<WebEpisodes>> getepds(@Url String url);
}
