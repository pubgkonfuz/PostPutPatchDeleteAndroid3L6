package com.example.postputpatchdeleteandroid3l6.utils

import android.app.Application
import androidx.room.Room
import com.example.postputpatchdeleteandroid3l6.data.local.room.database.JsonDatabase

private const val DATABASE_NAME = "post"
class App : Application() {

    companion object {
        lateinit var db: JsonDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            JsonDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}