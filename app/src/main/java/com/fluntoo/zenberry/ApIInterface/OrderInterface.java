package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Orders;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Url;

public interface OrderInterface {
//    @POST
//    Call<Orders> getorder(@Url String url,Integer amount,String currency,
//                          String receipt, Integer payment_capture);

    @POST("orders")
    Call<Orders> getoder(@Header("Authorization") String auth
            , @Body Orders orders);

}
