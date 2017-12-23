package rs.novotek.movieapiplayground.features.latestmovies

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
class LatestMoviesModule {

    @PerScreen
    @Provides
    fun provideGetMoviesUseCase(moviesRepository: MoviesRepository) = GetMovieUseCase(moviesRepository)

    @PerScreen
    @Provides
    fun providePresenter(schedulerProvider: SchedulerProvider, getMovieUseCase: GetMovieUseCase) = LatestMoviesPresenter(schedulerProvider, getMovieUseCase)

}
