package rs.novotek.domain.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import rs.novotek.domain.model.Movies

/**
 * Created by Mike on 12/23/2017.
 */
interface MoviesRepository {
    fun insertOrUpdate(note: Movies): Completable

    fun delete(note: Movies): Completable

    fun getMovie(id: String): Maybe<Movies>

    fun getAllNotes(): Single<List<Movies>>
}