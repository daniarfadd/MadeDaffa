package com.example.madedaffa.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.madedaffa.core.data.Resource
import com.example.madedaffa.core.domain.model.Movie
import io.reactivex.Flowable

interface MovieUseCase {

    fun getAllMovie(): Flowable<com.example.madedaffa.core.data.Resource<List<Movie>>>
    fun getFavoriteMovie(): Flowable<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}