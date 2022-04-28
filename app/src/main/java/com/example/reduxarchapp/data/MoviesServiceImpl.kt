package com.example.reduxarchapp.data

import javax.inject.Inject

class MoviesServiceImpl @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesService {

    override suspend fun getTop250Movies() = moviesApi.getTop250Movies().body()?.map()

}
