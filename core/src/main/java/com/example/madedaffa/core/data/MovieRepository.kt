package com.example.madedaffa.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.madedaffa.core.data.source.local.LocalDataSource
import com.example.madedaffa.core.data.source.remote.RemoteDataSource
import com.example.madedaffa.core.data.source.remote.network.ApiResponse
import com.example.madedaffa.core.data.source.remote.response.MovieResponse
import com.example.madedaffa.core.domain.model.Movie
import com.example.madedaffa.core.domain.repository.IMovieRepository
import com.example.madedaffa.core.utils.AppExecutors
import com.example.madedaffa.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieRepository (
    private val remoteDataSource: com.example.madedaffa.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.example.madedaffa.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {


    override fun getAllMovie(): Flowable<com.example.madedaffa.core.data.Resource<List<Movie>>> =
        object : com.example.madedaffa.core.data.NetworkBoundResource<List<Movie>, List<MovieResponse>>() {
            override fun loadFromDB(): Flowable<List<Movie>> {
                return localDataSource.getAllMovie().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): Flowable<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getFavoriteMovie(): Flowable<List<Movie>> {
        return localDataSource.getFavoriteMovie().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movieEntity, state) }
    }
}