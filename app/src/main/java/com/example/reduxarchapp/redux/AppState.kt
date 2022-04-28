package com.example.reduxarchapp.redux

import com.example.reduxarchapp.domain.Movie

data class AppState(
    val movies: List<Movie> = listOf(),
    val errorMsg: String = "",
)
