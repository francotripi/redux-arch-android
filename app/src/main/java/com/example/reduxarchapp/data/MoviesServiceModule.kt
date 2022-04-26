package com.example.reduxarchapp.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class MoviesServiceModule {

    @Binds
    abstract fun bindAMoviesService(
        moviesServiceImpl: MoviesServiceImpl
    ): MoviesService
}
