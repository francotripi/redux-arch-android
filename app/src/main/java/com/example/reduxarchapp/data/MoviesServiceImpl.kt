package com.example.reduxarchapp.data

import com.example.reduxarchapp.redux.Actions
import com.example.reduxarchapp.redux.store
import javax.inject.Inject

class MoviesServiceImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesService {

    override suspend fun getTop250Movies() {
        with(moviesApi.getTop250Movies()) {
            if (isSuccessful) {
                store.dispatch(Actions.FetchingMoviesSuccess(items = body()?.map()?.items.orEmpty()))
            } else {
                store.dispatch(Actions.FetchingMoviesFailed(message = body()?.map()?.errorMsg.orEmpty()))
            }
        }
    }

}