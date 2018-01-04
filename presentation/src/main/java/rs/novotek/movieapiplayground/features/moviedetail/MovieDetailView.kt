/*
 * MovieDetailView.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 1/4/2018
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.moviedetail

import android.util.Log
import android.view.View
import rs.novotek.domain.model.movie.Movies
import rs.novotek.movieapiplayground.MovieApiPlaygroundApp
import rs.novotek.movieapiplayground.R
import rs.novotek.movieapiplayground.mvp.BaseView
import javax.inject.Inject

class MovieDetailView : BaseView(), MovieDetailContract.View {

    companion object {
        const val EXTRA_MOVIE_ID = "MovieDetailView.movieId"
    }

    @Inject
    lateinit var presenter: MovieDetailPresenter

    override fun showLoading() {

        Log.d("", "something show")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        Log.d("", "something hide")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies() {
        DaggerMovieDetailComponent.builder()
                .movieDetailModule(MovieDetailModule())
                .appComponent(MovieApiPlaygroundApp.appComponent)
                .build()
                .inject(this)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.start(this)
        presenter.loadMovie(args.getInt(EXTRA_MOVIE_ID))
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        presenter.stop()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun onLoadMovieSuccess(movies: Movies) {
        Log.d("loger", "movie is "+ movies.originalTitle)
        showMessage("Loaded movie details for " + movies.originalTitle)
    }

    override fun onLoadMovieError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId() = R.layout.movie_detail_layout

    override fun getToolbarTitleId() = R.string.novie_detail_title

}