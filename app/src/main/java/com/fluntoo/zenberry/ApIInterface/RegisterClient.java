package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ForgetPassNew;
import com.fluntoo.zenberry.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RegisterClient {
//    @POST("/register")
//    Call<User> PostData(@Body User user);
//
//
//   Call<User> PostData(String userName1, String userMail1, String userPassword1, String userPhonenumber1);


    @POST("/register")
    @FormUrlEncoded
    Call<User> createregister(@Field("userName") String userName, @Field("userMail") String euserMail,
                              @Field("userPassword") String userPassword, @Field("userPhonenumber") String userPhonenumber);


    @FormUrlEncoded
    @POST
    Call<User> registertobackend(String url,@Field("userName") String userName,
                                 @Field("userMail") String euserMail,
                                 @Field("userPassword") String userPassword,
                                 @Field("userPhonenumber") String userPhonenumber);

    @PUT
    Call<ForgetPassNew> putchange(@Url String url, @Query("mobileno") String number,
                                  @Query("password") String pass);
}

