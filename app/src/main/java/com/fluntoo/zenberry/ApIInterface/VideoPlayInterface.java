package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VideoPlayInterface {
@GET("videoplay/{description}")
    Call<List<Category>> getCategory(@Path("description") String desc);

}
