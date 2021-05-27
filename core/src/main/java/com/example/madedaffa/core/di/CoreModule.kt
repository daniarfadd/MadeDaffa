package com.example.madedaffa.core.di

import androidx.room.Room
import com.example.madedaffa.core.data.MovieRepository
import com.example.madedaffa.core.data.source.local.LocalDataSource
import com.example.madedaffa.core.data.source.local.room.MovieDatabase
import com.example.madedaffa.core.data.source.remote.RemoteDataSource
import com.example.madedaffa.core.data.source.remote.network.ApiService
import com.example.madedaffa.core.domain.repository.IMovieRepository
import com.example.madedaffa.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<com.example.madedaffa.core.data.source.local.room.MovieDatabase>().movieDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            com.example.madedaffa.core.data.source.local.room.MovieDatabase::class.java, "movie.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { com.example.madedaffa.core.data.source.local.LocalDataSource(get()) }
    single { com.example.madedaffa.core.data.source.remote.RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IMovieRepository> {
        com.example.madedaffa.core.data.MovieRepository(
            get(),
            get(),
            get()
        )
    }
}