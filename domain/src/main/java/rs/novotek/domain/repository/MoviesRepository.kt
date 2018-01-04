/*
 * MoviesRepository.java
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/23/2017
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.domain.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.movie.Movies

interface MoviesRepository {
    fun insertOrUpdate(note: Movies): Completable

    fun delete(note: Movies): Completable

    fun getMovie(id: Int): Maybe<Movies>

    fun discoverMovies(pageNr: Int): Maybe<DiscoverMovies>

    fun getAllNotes(): Single<List<Movies>>
}