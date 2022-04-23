package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface PlaylistInterface {
    @GET
    Call<List<Playlist>> getplaylist(@Url  String url,
                                     @Header("Authorization") String auth);
}
