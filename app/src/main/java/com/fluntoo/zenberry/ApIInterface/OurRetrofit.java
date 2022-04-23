package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.OurDataSet;
import com.fluntoo.zenberry.Model.OurDataSet1;
import com.fluntoo.zenberry.Model.OurDataSet2;
import com.fluntoo.zenberry.Model.OurDataSet4;
import com.fluntoo.zenberry.Model.OurDataSet5;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OurRetrofit {
    @POST("/register")
    Call<OurDataSet> PostData(@Body OurDataSet ourDataSet);

    @POST("/register")
    Call<OurDataSet1> PostData1(@Body OurDataSet1 ourDataSet1);


    @POST("user/register")
    Call<OurDataSet2> PostData2(@Body OurDataSet2 ourDataSet2);

    @POST("user/android/register")
    Call<OurDataSet4> PostData4(@Body OurDataSet4 ourDataSet4);

    @POST("user/android/login")
    Call<OurDataSet5> PostData5(@Body OurDataSet5 ourDataSet5);


}
