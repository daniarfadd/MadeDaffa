package com.example.madedaffa.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (

    @SerializedName("id")
    var movieId: Int = 0,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("overview")
    var description: String? = null,
    @SerializedName("release_date")
    var date: String? = null,
    @SerializedName("poster_path")
    var imagePath: String? = null,
    @SerializedName("vote_average")
    var releaseDate: String? = null

)