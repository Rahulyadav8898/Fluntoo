package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Videolist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface VideolistInterface {

    @GET
    Call<List<Videolist>> getVideoslist(@Header("Authorization") String auth
            , @Url String url);





}
