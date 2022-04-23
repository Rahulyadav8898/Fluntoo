package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ChannelINfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ChannelINfoInterface {
    @GET
    Call<ChannelINfo> getchannelinfo(@Url String url);
}
