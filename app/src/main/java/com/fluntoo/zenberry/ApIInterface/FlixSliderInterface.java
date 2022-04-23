package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.FlixSlider;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FlixSliderInterface {
    @GET
    Call<List<FlixSlider>> getslider(@Url String url);
}
