package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.OtpVerify;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface VerificationOtpINterface {
    @FormUrlEncoded
    @POST
    Call<OtpVerify> postotp(@Url String url, @Field("Token") String token);

    @POST
    Call<OtpVerify> resendotp(@Url String url);
}
