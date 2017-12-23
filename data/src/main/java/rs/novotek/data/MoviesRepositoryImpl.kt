package rs.novotek.data

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import rs.novotek.domain.model.Movies
import rs.novotek.domain.repository.MoviesRepository

/**
 * Created by Mike on 12/23/2017.
 */
class MoviesRepositoryImpl: MoviesRepository {
    override fun insertOrUpdate(note: Movies): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(note: Movies): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMovie(id: String): Maybe<Movies> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllNotes(): Single<List<Movies>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}