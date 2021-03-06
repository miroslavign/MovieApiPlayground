/*
 * MoviesRepositoryImpl.kt
 * MovieApiPlayground
 *
 * Created by Miroslav Ignjatovic on 12/23/2016
 * Copyright (c) 2017 Novotek All rights reserved.
 */

package rs.novotek.data

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import rs.novotek.domain.backend.RestApi
import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.movie.Movies
import rs.novotek.domain.repository.MoviesRepository

class MoviesRepositoryImpl(private val restApi: RestApi): MoviesRepository {
    override fun discoverMovies(pageNr: Int): Maybe<DiscoverMovies> {
        return restApi.restService
                .disoverMovies(pageNr)
                .toMaybe()
    }

    override fun insertOrUpdate(note: Movies): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(note: Movies): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: Int): Maybe<Movies> {
        return restApi.restService
                .getMovie(id)
                .toMaybe()
    }

    override fun getAllNotes(): Single<List<Movies>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}