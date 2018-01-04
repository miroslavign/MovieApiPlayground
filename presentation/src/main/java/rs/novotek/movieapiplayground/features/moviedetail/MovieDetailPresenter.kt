/*
 * MovieDetailPresenter.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 1/4/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.moviedetail

import rs.novotek.domain.usecases.GetMovieUseCase
import rs.novotek.domain.util.SchedulerProvider
import rs.novotek.movieapiplayground.mvp.BasePresenter
import javax.inject.Inject

class MovieDetailPresenter @Inject constructor(private val schedulerProvider: SchedulerProvider, private val getMovieUseCase: GetMovieUseCase) : BasePresenter<MovieDetailView>(), MovieDetailContract.Presenter {

    override fun loadMovie(id: Int) {
        disposables.add(getMovieUseCase.loadMovie(id)
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
                .doOnSubscribe { view?.showLoading() }
                .doFinally { view?.hideLoading() }
                .subscribe({ view?.onLoadMovieSuccess(it) }, { view?.onLoadMovieError(it) }))
    }

}
