package com.example.madedaffa.home

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.madedaffa.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = LiveDataReactiveStreams.fromPublisher(movieUseCase.getAllMovie())
}

//class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
//    val movie = movieUseCase.getAllMovie().asLiveData()
//}