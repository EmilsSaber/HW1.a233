package com.example.hw1a2

import android.app.Application
import androidx.room.Room
import com.example.hw1a2.room.AppDatabas

class App: Application() {
   companion object {
      lateinit var database: AppDatabas
   }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabas::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

}