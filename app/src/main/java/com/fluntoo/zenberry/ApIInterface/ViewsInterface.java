package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Dislike;
import com.fluntoo.zenberry.Model.Views;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ViewsInterface {

    @PUT
    Call<Views> putview(@Url String url,@Query("Views") long views);
}
