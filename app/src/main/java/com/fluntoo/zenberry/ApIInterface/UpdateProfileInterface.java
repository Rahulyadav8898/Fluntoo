package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.UpdateProfileImg;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UpdateProfileInterface {
    @Multipart
    @PUT
    Call<UpdateProfileImg> updateprofile(@Url String url,
                                         @Header("Authorization") String auth,
                                         @Query("UserId") long userid,
                                         @Part MultipartBody.Part photo);

}
