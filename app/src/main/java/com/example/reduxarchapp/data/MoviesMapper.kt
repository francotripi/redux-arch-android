package com.example.reduxarchapp.data

import com.example.reduxarchapp.domain.Movie
import com.example.reduxarchapp.domain.Movies

fun MoviesDto.map() = Movies(
    items = items?.map { it.map() }.orEmpty(),
    errorMsg = errorMsg.orEmpty(),
)

fun MovieDto.map() = Movie(
    title = title.orEmpty()
)
