package com.example.postputpatchdeleteandroid3l6.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postputpatchdeleteandroid3l6.data.model.Post
@Dao
interface JsonDao {

    @Query("SELECT * FROM Post")
    fun getPosts(): List<Post>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPost(post: Post)

}