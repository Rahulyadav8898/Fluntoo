package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Latest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LatestInterface {
    @GET("latestvideo")
    Call<List<Latest>> getlatest();
}
