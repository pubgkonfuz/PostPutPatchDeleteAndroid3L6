package com.example.postputpatchdeleteandroid3l6.data.repositories

import com.example.postputpatchdeleteandroid3l6.data.model.Post
import com.example.postputpatchdeleteandroid3l6.data.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JsonRepository {

    private val jsonApiService = RetrofitClient.JsonResponse

    fun createNewPost(
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        jsonApiService.createNewPost(post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun updateNewPost(
        postId: Int,
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit,
    ) {
        jsonApiService.updateNewPost(postId = postId, post = post).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun editPost(
        postParams: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit
    ) {
        jsonApiService.editPost(postParams.title).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }

    fun deleteNewPost(
        postId: Int,
        post: Post,
        onResponse: (post: Post) -> Unit,
        onFailure: (message: String, t: Throwable) -> Unit,
    ){
        jsonApiService.deletePost(postId = postId).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful && response.body() != null) {
                    onResponse(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                onFailure(t.message ?: "Unknown error!", t)
            }
        })
    }
}