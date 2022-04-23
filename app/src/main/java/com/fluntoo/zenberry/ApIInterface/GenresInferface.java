package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Genres;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GenresInferface {

    @GET
    Call<List<Genres>> getgenres(@Url String url);
}
