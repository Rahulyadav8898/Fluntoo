package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.WebRecommended;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebRecommendedInterface {
    @GET
    Call<List<WebRecommended>> getwebrec(@Url String url);
}
