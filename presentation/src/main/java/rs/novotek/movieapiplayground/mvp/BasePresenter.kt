/*
 * BasePresenter.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/20/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<V : BaseView> {

    protected val disposables: CompositeDisposable = CompositeDisposable()
    protected var view: V? = null
        private set

    fun start(view: V) {
        this.view = view
    }

    fun stop() {
        this.view = null
    }

    fun destroy() {
        disposables.clear()
    }
}