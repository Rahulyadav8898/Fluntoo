package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.LatestMusic;
import com.fluntoo.zenberry.Model.Music;
import com.fluntoo.zenberry.Model.TrendingMusic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface MusicINterface {
    @GET
    Call<List<Music>> getmusic(@Url String Url);

    @GET
    Call<List<LatestMusic>> getlatestmusic(@Url String url1);

    @GET
    Call<List<TrendingMusic>> gettrendingmusic(@Url String url2);
}
