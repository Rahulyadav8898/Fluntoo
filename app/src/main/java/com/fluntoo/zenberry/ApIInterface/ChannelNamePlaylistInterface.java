package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.ChannelPlaylist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ChannelNamePlaylistInterface {

    @GET
    Call<List<ChannelPlaylist>> getplaylist(@Url String Url);
}
