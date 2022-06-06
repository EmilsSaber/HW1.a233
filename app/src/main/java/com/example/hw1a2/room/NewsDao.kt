package com.example.hw1a2.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.hw1a2.News

@Dao
interface NewsDao {
    @Insert
    fun insert (news: News)
}