package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.DeleteCoverPic;
import com.fluntoo.zenberry.Model.DeleteProfilePic;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface DeleteCoverPicINterface {

    @DELETE
    Call<DeleteCoverPic> deletecover(@Url String url,
                                     @Query("CoverPic") String cover);

    @DELETE
    Call<DeleteProfilePic> deleteprof(@Url String url,
                                      @Query("ProfilePic") String prof);
}
