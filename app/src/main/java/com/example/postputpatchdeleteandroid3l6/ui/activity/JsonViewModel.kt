package com.example.postputpatchdeleteandroid3l6.ui.activity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.postputpatchdeleteandroid3l6.data.model.Post
import com.example.postputpatchdeleteandroid3l6.data.repositories.JsonRepository
import com.example.postputpatchdeleteandroid3l6.data.repositories.RoomRepository

class JsonViewModel : ViewModel() {

    private val jsonRepository = JsonRepository()
    private val roomRepository = RoomRepository()

    fun createNewPost(
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ){
        jsonRepository.createNewPost(
            post = post,
            onResponse = onSuccess,
            onFailure = { _, t ->
                val message = t.message ?: "Unknown error!"
                Log.e("createNewPost", message)
                onFailure(t.message ?: "Unknown error!")
            }
        )
    }

    fun updatePost(
        postId: Int,
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ){
        jsonRepository.updateNewPost(
            postId = postId,
            post = post,
            onResponse = onSuccess,
            onFailure = { _, t ->
                val message = t.message ?: "Unknown error!"
                Log.e("updateNewPost", message)
                onFailure(t.message ?: "Unknown error!")
            }
        )
    }

    fun editPost(
        postParams: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ){
      jsonRepository.editPost(
          postParams = postParams,
          onResponse = onSuccess
      ) { _, t ->
          val message = t.message ?: "Unknown error!"
          Log.e("editNewPost", message)
          onFailure(t.message ?: "Unknown error!")
      }
    }

    fun deletePost(
        postId: Int,
        post: Post,
        onSuccess: (post: Post) -> Unit,
        onFailure: (message: String) -> Unit
    ){
        jsonRepository.deleteNewPost(
            postId = postId,
            post = post,
            onResponse = onSuccess,
            onFailure = { _, t ->
                val message = t.message ?: "Unknown error!"
                Log.e("deleteNewPost", message)
                onFailure(t.message ?: "Unknown error!")
            }
        )
    }

    fun addData(post: Post) {
        roomRepository.addData(post)
    }

    //получение с room
    fun fetchData(): List<Post> {
        return roomRepository.fatchData()
    }
}