package com.fluntoo.zenberry.ApIInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SkipInterface {

//    @POST("skips")
//    Call<Skip> Postskip(@Body Skip skip);

    @GET("getid")
    Call<ResponseBody> getskip();
}
