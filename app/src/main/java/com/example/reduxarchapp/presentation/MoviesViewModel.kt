package com.example.reduxarchapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxarchapp.data.MoviesService
import com.example.reduxarchapp.redux.Actions
import com.example.reduxarchapp.redux.store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesService: MoviesService
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    fun getMovies() {
        viewModelScope.launch {
            try {
                moviesService.getTop250Movies()?.let {
                    store.dispatch(Actions.FetchingMoviesSuccess(items = it.items))
                }
            } catch (e: Exception) {
                store.dispatch(Actions.FetchingMoviesFailed(message = e.message.orEmpty()))
            }
        }
    }

}
