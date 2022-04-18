package com.example.reduxarchapp.redux

import com.example.reduxarchapp.data.MovieDto

sealed class Actions {
    data class FetchingMoviesSuccess(val items: List<MovieDto>) : Actions()
    data class FetchingMoviesFailed(val message: String) : Actions()
}
