package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ChannelNameVideoList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ChannelNameVideoInterface {
    @GET
    Call<List<ChannelNameVideoList>> getvideolist(@Url String url);
}
