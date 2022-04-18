package com.example.reduxarchapp.data

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("items") val items: List<Movie>? = null,
    @SerializedName("errorMessage") val errorMsg: String? = null
)

data class Movie(
    @SerializedName("title") val title: String? = null,
)
