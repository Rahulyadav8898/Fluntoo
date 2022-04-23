package com.fluntoo.zenberry.ApIInterface;

import com.fluntoo.zenberry.Model.Comments;
import com.fluntoo.zenberry.Model.GetComments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface CommentsInterface {



    @FormUrlEncoded
    @POST
//Call<Comments> postcomments(@Url String url,@Body Comments comments);

    Call<Comments> postcomment(@Url String url, @Field("Comments") String comment);


    @GET
    Call<List<GetComments>> getcomment(@Url String Url);
}

