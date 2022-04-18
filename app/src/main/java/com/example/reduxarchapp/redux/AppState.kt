package com.example.reduxarchapp.redux

import com.example.reduxarchapp.data.Movie

data class AppState(
    val movies: List<Movie> = listOf(),
    val errorMsg: String = "",
)
