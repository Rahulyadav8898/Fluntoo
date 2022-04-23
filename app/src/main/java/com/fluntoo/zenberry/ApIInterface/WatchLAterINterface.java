package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Playwatchlater;
import com.fluntoo.zenberry.Model.PostItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface WatchLAterINterface {

    @POST
    Call<PostItem> watchpost(@Url String url);

    @GET
    Call<List<Playwatchlater>>getwatchlist(@Url String url);

    @DELETE
    Call<Playwatchlater> deletewatchlist(@Url String url);
}
