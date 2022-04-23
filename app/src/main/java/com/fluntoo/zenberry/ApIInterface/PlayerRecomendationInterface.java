package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.PlayerRecommendation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PlayerRecomendationInterface {

    @GET
    Call<List<PlayerRecommendation>> getrecomendedlist(@Url String url);
}
