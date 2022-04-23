package com.fluntoo.zenberry.ApIInterface;

import android.text.format.Time;

import com.fluntoo.zenberry.Model.WatchTime;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ContinueWatchingInterface {
    @FormUrlEncoded
    @POST
    Call<WatchTime> getwatchtime(@Url String url, @Field("WatchTime") Time watchtime);
}
