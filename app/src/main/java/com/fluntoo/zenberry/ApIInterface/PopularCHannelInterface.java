package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ChannelPopular;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface PopularCHannelInterface {
    @POST
    Call<List<ChannelPopular>> getlist(@Url String url);
}
