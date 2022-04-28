package com.example.reduxarchapp.data


interface MoviesService {

    suspend fun getTop250Movies()
}