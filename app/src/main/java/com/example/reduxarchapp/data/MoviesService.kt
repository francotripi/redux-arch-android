package com.example.reduxarchapp.data

import com.example.reduxarchapp.redux.Actions
import com.example.reduxarchapp.redux.store
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

class MoviesService : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://imdb-api.com/en/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getMovies() {
        launch {
            val call = getRetrofit().create(MoviesApi::class.java).getMovies()
            if (call.isSuccessful) {
                store.dispatch(Actions.FetchingMoviesSuccess(items = call.body()?.items.orEmpty()))
            } else {
                store.dispatch(Actions.FetchingMoviesFailed(message = call.body()?.errorMsg.orEmpty()))
            }
        }
    }

}