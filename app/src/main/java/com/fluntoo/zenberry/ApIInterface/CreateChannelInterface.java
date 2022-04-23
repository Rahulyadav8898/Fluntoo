package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.CreateChannel;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface CreateChannelInterface {
//
//    @Multipart
//    @POST
//    Call<CreateChannel> createchannel(@Header ("Authorization") String auth,@Url String url,
//                                      @Part ("ChannelName") RequestBody channelname,
//                                      @Part ("ChannelDescription") RequestBody channeldesc,
//                                      @Part ("ProfilePic") RequestBody photo,
//                                      @Part ("CoverPic") RequestBody photo1);




    @Multipart
    @POST
    Call<CreateChannel> createchannel(@Header ("Authorization") String auth,@Url String url,
                                      @Part("ChannelName")RequestBody channelname,
                                      @Part("ChannelDescription")RequestBody channeldesc,
                                      @Part MultipartBody.Part photo,
                                      @Part MultipartBody.Part photo1,
                                      @Part("Facebook") RequestBody facebook,
                                      @Part(" Twitter") RequestBody twitter,
                                      @Part("LinkedIn")RequestBody linkedin,
                                      @Part("GoogleBusiness") RequestBody googlebusiness,
                                      @Part("Instagram") RequestBody instagram);

}


