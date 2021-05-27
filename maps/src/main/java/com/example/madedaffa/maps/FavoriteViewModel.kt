package com.example.madedaffa.maps

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.madedaffa.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteMovie = LiveDataReactiveStreams.fromPublisher(movieUseCase.getFavoriteMovie())
}