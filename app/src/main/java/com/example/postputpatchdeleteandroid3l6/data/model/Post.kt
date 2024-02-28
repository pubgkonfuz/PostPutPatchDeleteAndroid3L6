package com.example.postputpatchdeleteandroid3l6.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Post(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("userId")
    val userId: Int
)
