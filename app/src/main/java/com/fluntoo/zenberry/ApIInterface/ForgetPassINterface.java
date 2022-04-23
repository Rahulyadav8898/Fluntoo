package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Forgetpass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ForgetPassINterface {
    @FormUrlEncoded
    @POST
    Call<Forgetpass> postemail(@Url String Url,
                               @Field("email") String email);
}
