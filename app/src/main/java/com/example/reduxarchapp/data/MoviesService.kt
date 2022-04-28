package com.example.reduxarchapp.data

import com.example.reduxarchapp.domain.Movies

interface MoviesService {

    suspend fun getTop250Movies(): Movies?
}
