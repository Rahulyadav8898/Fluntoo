package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.WebTrending;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface WebWatchlaterInterface {

    @POST
    Call<WebTrending> postwatchlater(@Url String url);

    @GET
    Call<List<WebTrending>> getwatchlist(@Url String url);

    @DELETE
    Call<WebTrending> deletewatchlist(@Url String url);

}
