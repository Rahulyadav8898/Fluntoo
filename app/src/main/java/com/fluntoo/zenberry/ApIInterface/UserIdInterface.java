package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.OurDataSetLogin;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserIdInterface {
    @GET("id")
    Call<OurDataSetLogin> getuserid();
}
