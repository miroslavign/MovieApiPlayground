package rs.novotek.domain.usecases

import io.reactivex.Maybe
import io.reactivex.Single
import rs.novotek.domain.model.Movies
import rs.novotek.domain.repository.MoviesRepository

/**
 * Created by Mike on 12/23/2017.
 */
class GetMovieUseCase(private val repository: MoviesRepository) {

    fun loadMovie(id: String): Maybe<Movies> = repository.getMovie(id)

}