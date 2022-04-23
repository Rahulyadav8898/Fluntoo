package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Notification;
import com.fluntoo.zenberry.Model.NotificationModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface NotificationInterface {
    @GET
    Call<List<Notification>> getnotificaton(@Url String url,
                                            @Header("Authorization") String auth);

    @GET
    Call<NotificationModel> getnoti(@Url String Url);
}
