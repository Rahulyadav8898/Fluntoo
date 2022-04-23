package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Music;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface LikeMusicINterface {

    @POST
    Call<Music> postlike(@Url String url);

}
