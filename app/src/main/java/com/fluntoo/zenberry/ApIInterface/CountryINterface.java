package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.CountryList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CountryINterface {

    @GET
    Call<List<CountryList>> countrypick(@Url String url);
}
