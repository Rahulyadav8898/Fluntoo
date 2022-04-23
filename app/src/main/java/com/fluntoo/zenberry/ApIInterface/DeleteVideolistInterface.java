package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Videolist;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface DeleteVideolistInterface {
    @DELETE
    Call<Videolist> deletevideolist(@Url String url, @Header("Authorization") String auth);
}
