package com.example.madedaffa.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.madedaffa.core.data.source.local.entity.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable


@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flowable<List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM movie where isFavorite = 1")
    fun getFavoriteMovie(): Flowable<List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>): Completable

    @Update
    fun updateFavoriteMovie(movie: com.example.madedaffa.core.data.source.local.entity.MovieEntity)
}