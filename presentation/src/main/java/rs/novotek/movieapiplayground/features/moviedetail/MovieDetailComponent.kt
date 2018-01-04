/*
 * MovieDetailComponent.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 1/4/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.moviedetail

import dagger.Component
import rs.novotek.movieapiplayground.di.AppComponent
import rs.novotek.movieapiplayground.di.PerScreen

@PerScreen
@Component(modules = [MovieDetailModule::class]
        , dependencies = [AppComponent::class])
interface MovieDetailComponent {
    fun inject(view: MovieDetailView)
}