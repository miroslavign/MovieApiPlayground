/*
 * LatestMoviesPresenter.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/11/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.latestmovies

import rs.novotek.domain.usecases.GetMovieUseCase
import rs.novotek.domain.util.SchedulerProvider
import rs.novotek.movieapiplayground.mvp.BasePresenter
import javax.inject.Inject

class LatestMoviesPresenter @Inject constructor(private val schedulerProvider: SchedulerProvider, private val getMovieUseCase: GetMovieUseCase) : BasePresenter<LatestMoviesView>(), LatestMoviesContract.Presenter {

    override fun discoverMovies(pageNr: Int) {
        disposables.add(getMovieUseCase.discoverMovies(pageNr)
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
                .doOnSubscribe { view?.showLoading() }
                .doFinally { view?.hideLoading() }
                .subscribe({ view?.onDiscoverMoviesSuccess(it) }, { view?.onDiscoverMoviesError(it) }))
    }

}
