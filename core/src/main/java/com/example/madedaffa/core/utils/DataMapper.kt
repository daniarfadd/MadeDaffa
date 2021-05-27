package com.example.madedaffa.core.utils

import com.example.madedaffa.core.data.source.local.entity.MovieEntity
import com.example.madedaffa.core.data.source.remote.response.MovieResponse
import com.example.madedaffa.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<com.example.madedaffa.core.data.source.local.entity.MovieEntity> {
        val movieList = ArrayList<com.example.madedaffa.core.data.source.local.entity.MovieEntity>()
        input.map {
            val movie = com.example.madedaffa.core.data.source.local.entity.MovieEntity(
                movieId = it.movieId,
                title = it.title,
                description = it.description,
                date = it.date,
                imagePath = it.imagePath,
                releaseDate = it.releaseDate,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<com.example.madedaffa.core.data.source.local.entity.MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                description = it.description,
                title = it.title,
                date = it.date,
                releaseDate = it.releaseDate,
                imagePath = it.imagePath,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) =
        com.example.madedaffa.core.data.source.local.entity.MovieEntity(
            movieId = input.movieId,
            description = input.description,
            title = input.title,
            date = input.date,
            releaseDate = input.releaseDate,
            imagePath = input.imagePath,
            isFavorite = input.isFavorite
        )
}