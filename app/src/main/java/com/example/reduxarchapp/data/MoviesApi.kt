package com.example.reduxarchapp.data

import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {

    @GET("Top250Movies")
    suspend fun getTop250Movies(): Response<Movies>
}
