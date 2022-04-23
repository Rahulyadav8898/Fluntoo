package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.InVoice;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface BillingInterface {
    @FormUrlEncoded
    @POST
    Call<InVoice> postvoice(@Url String url,
                            @Field("firstname") String fname,
                            @Field("lastname") String lname,
                            @Field("email") String email,
                            @Field("mobileno") String number,
                            @Field("userid") String userid,
                            @Field("address1") String adress1,
                            @Field("address2") String adress2,
                            @Field("pincode") String pin,
                            @Field("gstno") String gst,
                            @Field("country") String country,
                            @Field("state") String state,
                            @Field("city") String city,
                            @Field("couponcode") String coup,
                            @Field("pAmount") String pa,
                            @Field("finalAmount") String fa


    );

}
