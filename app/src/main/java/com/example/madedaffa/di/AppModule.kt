package com.example.madedaffa.di

import com.example.madedaffa.core.domain.usecase.MovieInteractor
import com.example.madedaffa.core.domain.usecase.MovieUseCase
import com.example.madedaffa.detail.DetailMovieViewModel
import com.example.madedaffa.favorite.FavoriteViewModel
import com.example.madedaffa.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}