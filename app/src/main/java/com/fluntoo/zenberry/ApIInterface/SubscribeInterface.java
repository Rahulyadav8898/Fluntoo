package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.PostItem;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface SubscribeInterface {

    @POST
    Call<PostItem> getsubcribe(@Url String url,@Header("Authorization") String auth);

    @PUT
    Call<PostItem> getbell(@Url String url, @Header("Authorization") String auth,
                           @Query("UserId") long user,
                           @Query("ChannelId") long Id,
                           @Query("bellicon") String bellicon);
}
