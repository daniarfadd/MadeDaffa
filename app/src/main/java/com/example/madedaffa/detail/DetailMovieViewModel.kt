package com.example.madedaffa.detail

import androidx.lifecycle.ViewModel
import com.example.madedaffa.core.domain.model.Movie
import com.example.madedaffa.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}