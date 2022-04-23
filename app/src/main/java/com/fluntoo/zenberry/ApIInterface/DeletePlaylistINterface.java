package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Playlist;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface DeletePlaylistINterface {

    @DELETE
    Call<Playlist> deleteplaylist(@Url String url, @Header("Authorization") String auth);
}
