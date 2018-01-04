/*
 * LatestMoviesContract.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/11/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.latestmovies

import rs.novotek.domain.model.discover.DiscoverMovies

interface LatestMoviesContract {
    interface View {
        fun onDiscoverMoviesSuccess(movie: DiscoverMovies)
        fun onDiscoverMoviesError(throwable: Throwable)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun discoverMovies(pageNr: Int)
    }
}