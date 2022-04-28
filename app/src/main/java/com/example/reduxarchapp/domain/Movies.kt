package com.example.reduxarchapp.domain

data class Movies(
    val items: List<Movie> = emptyList(),
    val errorMsg: String = "",
)

data class Movie(
    val title: String = "",
)
