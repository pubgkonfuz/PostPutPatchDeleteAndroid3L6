package com.example.postputpatchdeleteandroid3l6.data.remote.apiservices

import com.example.postputpatchdeleteandroid3l6.data.model.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

private const val JSON_KEY = "/posts"

interface JsonApiService {

    @POST(JSON_KEY)
    fun createNewPost(
        @Body post: Post
    ): Call<Post>

    @PUT("$JSON_KEY/{postId}")
    fun updateNewPost(
        @Path("postId") postId: Int,
        @Body post: Post
    ): Call<Post>

    @FormUrlEncoded
    @PATCH("$JSON_KEY/{title}")
    fun editPost(
        @Field("title") titleText: String
    ): Call<Post>

    @DELETE("$JSON_KEY/{postId}")
    fun deletePost(
        @Path("postId") postId: Int,
    ): Call<Post>
}