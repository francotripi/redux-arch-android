package com.example.reduxarchapp.redux

import com.example.reduxarchapp.data.MovieDto

data class AppState(
    val movies: List<MovieDto> = listOf(),
    val errorMsg: String = "",
)
