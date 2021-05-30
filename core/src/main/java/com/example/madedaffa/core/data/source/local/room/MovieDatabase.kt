package com.example.madedaffa.core.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.madedaffa.core.data.source.local.entity.MovieEntity


@Database(entities = [com.example.madedaffa.core.data.source.local.entity.MovieEntity::class], version = 2, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): com.example.madedaffa.core.data.source.local.room.MovieDao


}