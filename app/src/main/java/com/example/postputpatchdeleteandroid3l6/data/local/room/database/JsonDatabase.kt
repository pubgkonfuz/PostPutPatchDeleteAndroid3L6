package com.example.postputpatchdeleteandroid3l6.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.postputpatchdeleteandroid3l6.data.local.room.dao.JsonDao
import com.example.postputpatchdeleteandroid3l6.data.model.Post

@Database(entities = [Post::class], version = 3, exportSchema = false)

abstract class JsonDatabase : RoomDatabase() {

    abstract val json: JsonDao
}