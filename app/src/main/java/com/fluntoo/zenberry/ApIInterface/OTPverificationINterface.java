package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Dislike;
import com.fluntoo.zenberry.Model.OtpVerification;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface OTPverificationINterface {
    @PUT
    Call<OtpVerification> putverify(@Url String url, @Query("OTP") String otp,
                                    @Query("password") String pass);
}
