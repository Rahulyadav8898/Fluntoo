package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.FlixLatest;
import com.fluntoo.zenberry.Model.FlixTrending;
import com.fluntoo.zenberry.Model.FlixWatchlater;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface FlixwatchlaterInterface {

    @POST
    Call<FlixLatest> postwatchlater(@Url String url);

    @GET
    Call<List<FlixTrending>> getwatchlist(@Url String url);


    @DELETE
    Call<FlixWatchlater> deletewatchlist(@Url String url);
}
