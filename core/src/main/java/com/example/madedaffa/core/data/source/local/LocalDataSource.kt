package com.example.madedaffa.core.data.source.local

import androidx.lifecycle.LiveData
import com.example.madedaffa.core.data.source.local.entity.MovieEntity
import com.example.madedaffa.core.data.source.local.room.MovieDao
import io.reactivex.Flowable

class LocalDataSource (private val movieDao: com.example.madedaffa.core.data.source.local.room.MovieDao) {

//    companion object {
//        private var instance: LocalDataSource? = null
//
//        fun getInstance(movieDao: MovieDao): LocalDataSource =
//            instance ?: synchronized(this) {
//                instance ?: LocalDataSource(movieDao)
//            }
//    }

    fun getAllMovie(): Flowable<List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>> = movieDao.getAllMovie()

    fun getFavoriteMovie(): Flowable<List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>> = movieDao.getFavoriteMovie()

    fun insertMovie(tourismList: List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>) = movieDao.insertMovie(tourismList)

    fun setFavoriteMovie(movie: com.example.madedaffa.core.data.source.local.entity.MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updateFavoriteMovie(movie)
    }
}