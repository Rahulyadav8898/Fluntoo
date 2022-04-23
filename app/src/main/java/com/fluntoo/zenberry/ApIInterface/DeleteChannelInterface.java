package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Channellist;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface DeleteChannelInterface {
    @DELETE
    Call<Channellist> deletechannel(@Url String url, @Header("Authorization") String auth);

}
