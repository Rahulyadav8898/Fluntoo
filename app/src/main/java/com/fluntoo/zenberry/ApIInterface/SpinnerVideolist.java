package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ListChannel;
import com.fluntoo.zenberry.Model.SpinnerVideo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface SpinnerVideolist {
    @GET
    Call<List<SpinnerVideo>> getchannelist(
            @Url String url, @Header("Authorization")String auth);
}
