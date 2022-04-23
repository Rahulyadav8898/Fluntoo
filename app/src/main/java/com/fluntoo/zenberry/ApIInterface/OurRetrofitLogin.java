package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.OurDataSetLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OurRetrofitLogin {

    @POST("user/login")
    Call<OurDataSetLogin> PostLogin(@Body OurDataSetLogin ourDataSetLogin);

    @GET("/login")
    Call<OurDataSetLogin> getuserid();

}
