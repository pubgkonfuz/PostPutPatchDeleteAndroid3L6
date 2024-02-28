package com.example.postputpatchdeleteandroid3l6.data.local.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.postputpatchdeleteandroid3l6.data.local.room.database.JsonDatabase

//object RoomClient {
//    private const val DATABASE_NAME = "json_placeholder_database"
//    lateinit var database: RoomDatabase
//    private set
//
//    fun init(context: Context) {
//        database = Room.databaseBuilder(
//            context, JsonDatabase::class.java, DATABASE_NAME
//        ).allowMainThreadQueries()
//            .fallbackToDestructiveMigration()
//            .build()
//    }
//}