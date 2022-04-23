package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Channellist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ChannellistInterface {
    @GET
    Call<List<Channellist>> getchannelist(@Url String url);
}
