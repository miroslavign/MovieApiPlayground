package rs.novotek.movieapiplayground.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import rs.novotek.domain.backend.RestApi
import rs.novotek.domain.repository.MoviesRepository
import rs.novotek.domain.util.SchedulerProvider
import rs.novotek.movieapiplayground.MainActivity
import rs.novotek.movieapiplayground.MovieApiPlaygroundApp
import rs.novotek.movieapiplayground.features.latestmovies.LatestMoviesModule
import rs.novotek.movieapiplayground.features.latestmovies.LatestMoviesView
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(application: MovieApiPlaygroundApp)
    fun inject(activity: MainActivity)

    fun exposeSchedulerProvider(): SchedulerProvider
    //fun inject(view: LatestMoviesView)
    fun exposeMoviesRepository(): MoviesRepository

    /*
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
    fun exposeRestApi(): RestApi
    */


}