package com.example.hw1a2

import android.content.Context

class Prefs(context: Context) {
    private val preferences = context.getSharedPreferences("settings.txt", Context.MODE_PRIVATE)

    fun saveState(){
        preferences.edit().putBoolean("isShown", true).apply()
    }

    fun isShown(): Boolean {
       return preferences.getBoolean("isShown", false)
    }

//----------------------------------------------------------------------------
//    fun isSaveEditName(){
//        prefs.edit().putBoolean("isSave",true).apply()
//    }
//
//    fun isSave(): String{
//        return  prefs.getBoolean("isSave", false)
//    }
}