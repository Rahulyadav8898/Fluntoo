package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Search;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface SearchInterface {
    @FormUrlEncoded
    @POST
    Call<ArrayList<String>> postsearch(@Url String url, @Field("term") String keyword,
                               @Field("userid") long userid);

//
//    @GET
//    Call<List<Search>> getsearchlist(@Url String url);

    @GET
    Call<List<Search>> getsearchlist(@Url String url, @Query("keyword") String keyword,
                                     @Query("userid") String userid);
}
