package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Dislike;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DislikeInterface {

//    @FormUrlEncoded
    @PUT
    Call<Dislike> putdislike(@Url String url, @Query("Dislikes") long dislike);
}
