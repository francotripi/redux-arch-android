package com.example.reduxarchapp.data

import com.google.gson.annotations.SerializedName

data class MoviesDto(
    @SerializedName("items") val items: List<MovieDto>? = null,
    @SerializedName("errorMessage") val errorMsg: String? = null
)

data class MovieDto(
    @SerializedName("title") val title: String? = null,
)
