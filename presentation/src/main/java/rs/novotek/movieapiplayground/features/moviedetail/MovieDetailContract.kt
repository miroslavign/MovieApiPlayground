/*
 * MovieDetailContract.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 1/4/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.moviedetail

import rs.novotek.domain.model.movie.Movies

interface MovieDetailContract {
    interface View {
        fun onLoadMovieSuccess(movie: Movies)
        fun onLoadMovieError(throwable: Throwable)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun loadMovie(id: Int)
    }
}