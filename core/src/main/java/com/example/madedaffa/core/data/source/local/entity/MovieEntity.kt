package com.example.madedaffa.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movie")
@Parcelize
data class MovieEntity(

//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    var id: Int? = null,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int = 0,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "imagePath")
    var imagePath:  String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,


    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable
