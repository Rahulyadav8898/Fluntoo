package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.MovieRecommended;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FlixREcommendedInterface {
    @GET
    Call<List<MovieRecommended>> getrec(@Url String url);
}
