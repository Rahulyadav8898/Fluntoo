package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Category;
import com.fluntoo.zenberry.Model.Categorys;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CategoryInterface {
    @GET("getAllNewCategory")
    Call<List<Category>> getcategory();

    @GET
    Call<List<Categorys>> getcategorys( @Url  String url);
}
