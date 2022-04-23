package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.CreateOrder;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface CreateOrderInterface {
    @FormUrlEncoded
    @POST
    Call<CreateOrder> createorder(@Url String url1,
//                                  @Header("Authorization") String auth,
                                  @Field("Amount") String Amount,
                                  @Field("Title") String Title);
}
