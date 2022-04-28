package com.example.reduxarchapp.presentation.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.reduxarchapp.domain.Movie

@Composable
fun MovieList(movies: List<Movie>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        movies.forEach { movie ->
            MovieRow(movie)
        }
    }
}

@Composable
fun MovieRow(movie: Movie) {
    Text(text = movie.title)
}
