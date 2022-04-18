package com.example.reduxarchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.reduxarchapp.data.MovieDto
import com.example.reduxarchapp.data.MoviesService
import com.example.reduxarchapp.redux.AppState
import com.example.reduxarchapp.redux.store
import com.example.reduxarchapp.ui.theme.ReduxArchAppTheme

class MainActivity : ComponentActivity() {

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

        MoviesService().getMovies()
    }
}

@Composable
fun MovieList(movies: List<MovieDto>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        movies.forEach { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: MovieDto) {
    Text(text = movie.title.orEmpty())
}
