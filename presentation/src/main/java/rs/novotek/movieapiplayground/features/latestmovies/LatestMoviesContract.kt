package rs.novotek.movieapiplayground.features.latestmovies

import rs.novotek.domain.model.Movies

/**
 * Created by BX on 12/11/2017.
 */
interface LatestMoviesContract {
    interface View {
        fun onLoadMovieSuccess(movie: Movies)
        fun onLoadMovieError(throwable: Throwable)
        fun onFabClicked()
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun loadMovie(id: String)
    }
}