package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Login;
import com.fluntoo.zenberry.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserClient {

    @POST("/login")
    Call<User> login(@Body Login login);
}
