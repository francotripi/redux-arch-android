package com.example.reduxarchapp.data

import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {
    @GET("Top250Movies/k_jkygze98")
    suspend fun getMovies(): Response<MoviesDto>
}
