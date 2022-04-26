package com.example.reduxarchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.reduxarchapp.data.MoviesService
import com.example.reduxarchapp.redux.AppState
import com.example.reduxarchapp.redux.store
import com.example.reduxarchapp.ui.composables.MovieList
import com.example.reduxarchapp.ui.theme.ReduxArchAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var moviesService: MoviesService

    private lateinit var state: MutableState<AppState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ReduxArchAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    state = remember { mutableStateOf(store.state) }
                    MovieList(movies = state.value.movies)
                }
            }
        }

        store.subscribe {
            state.value = store.state
        }

        moviesService.getMovies()
    }
}
