package com.example.madedaffa.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(
    val  movieId: Int,
    val  title: String?,
    val  description: String?,
    val  date: String?,
    val  imagePath: String?,
    val  releaseDate: String?,
    val  isFavorite: Boolean,

) : Parcelable
