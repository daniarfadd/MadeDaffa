package com.example.madedaffa.maps.di

import com.example.madedaffa.maps.FavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mapsModule = module {
    viewModel { FavoriteViewModel(get()) }
}