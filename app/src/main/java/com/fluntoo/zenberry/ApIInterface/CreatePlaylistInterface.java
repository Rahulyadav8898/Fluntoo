package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.CreatePlaylist;
import com.fluntoo.zenberry.Model.VideoUpload;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface CreatePlaylistInterface {
    @Multipart
    @POST
    Call<CreatePlaylist> createplaylist(@Header("Authorization") String auth,
                                     @Url String url,
                                     @Part("PlaylistTitle") RequestBody title,
                                     @Part("PlaylistDescription") RequestBody desc,
                                     @Part("PlaylistCategory") RequestBody cat,
                                     @Part("PlaylistTags") RequestBody tag,
                                     @Part("ChannelName") RequestBody channelname,
                                     @Part("VideoList")RequestBody videolist,

                                     @Part MultipartBody.Part photo);



}
