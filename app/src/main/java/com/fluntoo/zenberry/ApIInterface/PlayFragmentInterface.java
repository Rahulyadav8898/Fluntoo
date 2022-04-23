package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.PostItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PlayFragmentInterface {

//    @GET("getallvideolist")
//    Call<List<PostItem>> getdata();

    @GET()
    Call<List<PostItem>> getdata(@Url String url);


}
