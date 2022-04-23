package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Adapter.Channel_ChannelName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ChannelCHannelINterface {
    @GET
    Call<List<Channel_ChannelName>> getchannellist(@Url String url);

}
