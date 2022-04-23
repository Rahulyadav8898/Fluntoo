package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.FlixGenres;
import com.fluntoo.zenberry.Model.FlixGenresData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FlixGenresInterface {

    @GET("getAllGenres")
    Call<List<FlixGenres>> getdata();

    @GET
    Call<List<FlixGenresData>> getUsers(@Url String url);

}
