package com.example.reduxarchapp.redux

import org.reduxkotlin.Reducer

val reducer: Reducer<AppState> = { state, action ->
    when (action) {
        is Actions.FetchingMoviesSuccess -> state.copy(movies = action.items)
        is Actions.FetchingMoviesFailed -> state.copy(errorMsg = action.message)
        else -> state
    }
}
