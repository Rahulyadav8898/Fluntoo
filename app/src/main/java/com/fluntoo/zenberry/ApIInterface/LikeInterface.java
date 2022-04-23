package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Likes;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface LikeInterface {
//    @FormUrlEncoded
    @PUT
    Call<Likes> putlike(@Url String url, @Query("Likes") long like);

}
