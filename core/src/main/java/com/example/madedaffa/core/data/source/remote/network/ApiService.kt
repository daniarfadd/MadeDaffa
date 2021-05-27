package com.example.madedaffa.core.data.source.remote.network


import com.example.madedaffa.core.data.source.remote.response.ListMovieResponse
import com.example.madedaffa.core.data.source.remote.response.MovieResponse
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovie(@Query("api_key") apiKey: String =  "f9d84884625bedefa8d813389a7a303a"): Flowable<ListMovieResponse>

}