package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.UpdatePayment;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface UpdatePaymentInterface {

    @PUT
    Call<UpdatePayment> updatepayment(@Url String url, @Header("Authorization") String auth, @Query("PaymentId") String payid,
                                      @Query("status") String status);


}
