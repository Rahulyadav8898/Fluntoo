package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.SelectImage;
import com.fluntoo.zenberry.Model.SelectImage2;
import com.fluntoo.zenberry.Model.UploadedCover;
import com.fluntoo.zenberry.Model.UploadedProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UploadedInterface {
    @GET
    Call<List<UploadedCover>> getCover(@Url String url);

    @GET
    Call<List<UploadedProfile>> getpro(@Url String url);

    @PUT
    Call<SelectImage> putcover(@Url String url, @Header("Authorization") String auth,
                               @Query("ProfilePic") String img);
    @PUT
    Call<SelectImage2> putpro(@Url String url, @Header("Authorization") String auth,
                                @Query("CoverPic") String img);

}