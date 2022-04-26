package com.example.reduxarchapp.data

import com.example.reduxarchapp.redux.Actions
import com.example.reduxarchapp.redux.store
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MoviesServiceImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesService, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    override fun getMovies() {
        launch {
            val call = moviesApi.getMovies()
            if (call.isSuccessful) {
                store.dispatch(Actions.FetchingMoviesSuccess(items = call.body()?.items.orEmpty()))
            } else {
                store.dispatch(Actions.FetchingMoviesFailed(message = call.body()?.errorMsg.orEmpty()))
            }
        }
    }

}