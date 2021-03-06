package com.example.reduxarchapp.redux

import com.example.reduxarchapp.domain.Movie

sealed class Actions {
    data class FetchingMoviesSuccess(val items: List<Movie>) : Actions()
    data class FetchingMoviesFailed(val message: String) : Actions()
}
