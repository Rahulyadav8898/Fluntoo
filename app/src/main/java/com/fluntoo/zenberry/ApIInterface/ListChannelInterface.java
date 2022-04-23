package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ListChannel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ListChannelInterface {
    @GET
    Call<List<ListChannel>> getchannelist(
            @Url String url);


}
