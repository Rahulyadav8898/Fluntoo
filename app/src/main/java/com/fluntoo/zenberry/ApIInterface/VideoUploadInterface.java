package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.VideoUpload;
import com.fluntoo.zenberry.Model.Videoc;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface VideoUploadInterface {

    @Multipart
    @POST
    Call<VideoUpload> videoupload(@Header("Authorization") String auth,
                                  @Url String url,
                                  @Part("VideoTitle") RequestBody title,
                                  @Part("VideoDescription") RequestBody desc,
                                  @Part("VideoTags") RequestBody tags,
                                  @Part("VideoCategory") RequestBody category,
                                  @Part ("Videopath") RequestBody video,
                                  @Part MultipartBody.Part pic,
//                                  @Part MultipartBody.Part srtfile,
                                  @Part("languages") RequestBody lan,
                                  @Part("uid") RequestBody uid,
                                  @Part("private") RequestBody privat,
                                  @Part("kids") RequestBody kids
//                                  @Part("schedule") RequestBody sched
//                                  @Part("playbackurl") RequestBody play
    );


    @Headers({
            "X-Auth-Email: admin@zenberrydigitals.com",
            "X-Auth-Key: d907dd30098d32e1423a473d19462cbc39b7b"
    })
    @POST
    @Multipart
    Call<Videoc> videocup(
            @Url String url,
            @Part MultipartBody.Part fil);

}
