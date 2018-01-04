/*
 * GetMovieUseCase.java
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/23/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.domain.usecases

import io.reactivex.Maybe
import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.movie.Movies
import rs.novotek.domain.repository.MoviesRepository

class GetMovieUseCase(private val repository: MoviesRepository) {

    fun loadMovie(id: Int): Maybe<Movies> = repository.getMovie(id)

    fun discoverMovies(pageNr: Int): Maybe<DiscoverMovies> = repository.discoverMovies(pageNr)

}