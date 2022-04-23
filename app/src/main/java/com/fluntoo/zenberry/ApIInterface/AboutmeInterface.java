package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Aboutme;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AboutmeInterface {

    @GET
    Call<Aboutme> getaboutme(@Url String url);
}
