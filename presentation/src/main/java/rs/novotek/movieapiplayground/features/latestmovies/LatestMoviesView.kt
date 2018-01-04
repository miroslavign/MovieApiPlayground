/*
 * LatestMoviesView.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 11/30/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.movieapiplayground.features.latestmovies

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import butterknife.BindView
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.discover.Result
import rs.novotek.movieapiplayground.MovieApiPlaygroundApp
import rs.novotek.movieapiplayground.R
import rs.novotek.movieapiplayground.features.moviedetail.MovieDetailView
import rs.novotek.movieapiplayground.mvp.BaseView
import javax.inject.Inject

class LatestMoviesView : BaseView(), LatestMoviesContract.View {

    @BindView(R.id.recycler_view)
    lateinit var recyclerView: RecyclerView

    private lateinit var recyclerViewAdapter: LatestMoviesAdapter

    @Inject
    lateinit var presenter: LatestMoviesPresenter

    override fun showLoading() {

        Log.d("", "something show")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        Log.d("", "something hide")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies() {
        DaggerLatestMovieComponent.builder()
                .latestMoviesModule(LatestMoviesModule())
                .appComponent(MovieApiPlaygroundApp.appComponent)
                .build()
                .inject(this)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        initRecyclerView(view.context)
        presenter.start(this)
        //presenter.loadMovie("157336")
        presenter.discoverMovies(1)
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        presenter.stop()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun onDiscoverMoviesSuccess(movies: DiscoverMovies) {
        Log.d("loger", "movie is "+ movies.results.toString())
        recyclerViewAdapter.updateMovies(movies.results)
    }

    override fun onDiscoverMoviesError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initRecyclerView(context: Context) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerViewAdapter = LatestMoviesAdapter()
        recyclerViewAdapter.onItemClick = { onMovieClicked(it)}
        recyclerView.adapter = recyclerViewAdapter
    }

    private fun onMovieClicked(discoverMovie: Result) {
        val movieDetailView = MovieDetailView().apply {
            args.putInt(MovieDetailView.EXTRA_MOVIE_ID, discoverMovie.id)
        }
        router.pushController(RouterTransaction.with(movieDetailView)
                .pushChangeHandler(FadeChangeHandler())
                .popChangeHandler(FadeChangeHandler()))
    }

    override fun getLayoutId() = R.layout.latest_movies_layout

    override fun getToolbarTitleId() = R.string.all_movies_title



}