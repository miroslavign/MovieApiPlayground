/*
 * LatestMovieComponent.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/10/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.latestmovies

import dagger.Component
import rs.novotek.movieapiplayground.di.AppComponent
import rs.novotek.movieapiplayground.di.PerScreen

@PerScreen
@Component(modules = [LatestMoviesModule::class]
        , dependencies = [AppComponent::class])
interface LatestMovieComponent {
    fun inject(view: LatestMoviesView)
}