package com.example.reduxarchapp.data

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
abstract class MoviesModule {

    @Binds
    abstract fun bindAMoviesService(moviesServiceImpl: MoviesServiceImpl): MoviesService

    companion object {
        @Provides
        fun provideMoviesApi(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)
    }
}
