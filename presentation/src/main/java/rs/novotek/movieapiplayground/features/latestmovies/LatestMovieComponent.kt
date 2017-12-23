package rs.novotek.movieapiplayground.features.latestmovies

import dagger.Component
import rs.novotek.movieapiplayground.di.AppComponent
import rs.novotek.movieapiplayground.di.AppModule
import rs.novotek.movieapiplayground.di.PerScreen
import javax.inject.Singleton

@PerScreen
@Component(modules = [LatestMoviesModule::class]
        , dependencies = [AppComponent::class])
interface LatestMovieComponent {
    fun inject(view: LatestMoviesView)
}