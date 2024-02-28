package com.example.postputpatchdeleteandroid3l6.data.repositories

import com.example.postputpatchdeleteandroid3l6.data.model.Post
import com.example.postputpatchdeleteandroid3l6.utils.App

class RoomRepository {
    fun fatchData() = App.db.json.getPosts()

    fun addData(post: Post) {
        App.db.json.addPost(post)
    }
}