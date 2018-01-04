/*
 * MovieDetailModule.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 1/4/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.moviedetail

import dagger.Module
import dagger.Provides
import rs.novotek.domain.repository.MoviesRepository
import rs.novotek.domain.usecases.GetMovieUseCase
import rs.novotek.domain.util.SchedulerProvider
import rs.novotek.movieapiplayground.di.PerScreen

/**
 * Created by Mike on 12/23/2017.
 */
@Module()
class MovieDetailModule {

    @PerScreen
    @Provides
    fun provideGetMoviesUseCase(moviesRepository: MoviesRepository) = GetMovieUseCase(moviesRepository)

    @PerScreen
    @Provides
    fun providePresenter(schedulerProvider: SchedulerProvider, getMovieUseCase: GetMovieUseCase) = MovieDetailPresenter(schedulerProvider, getMovieUseCase)

}
