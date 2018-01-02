package rs.novotek.domain.usecases

import io.reactivex.Maybe
import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.movie.Movies
import rs.novotek.domain.repository.MoviesRepository

/**
 * Created by Mike on 12/23/2017.
 */
class GetMovieUseCase(private val repository: MoviesRepository) {

    fun loadMovie(id: String): Maybe<Movies> = repository.getMovie(id)

    fun discoverMovies(pageNr: Int): Maybe<DiscoverMovies> = repository.discoverMovies(pageNr)

}