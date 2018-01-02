package rs.novotek.movieapiplayground.features.latestmovies

import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.movie.Movies

/**
 * Created by BX on 12/11/2017.
 */
interface LatestMoviesContract {
    interface View {
        fun onLoadMovieSuccess(movie: Movies)
        fun onLoadMovieError(throwable: Throwable)
        fun onDiscoverMoviesSuccess(movie: DiscoverMovies)
        fun onDiscoverMoviesError(throwable: Throwable)
        fun onFabClicked()
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun loadMovie(id: String)
        fun discoverMovies(pageNr: Int)
    }
}