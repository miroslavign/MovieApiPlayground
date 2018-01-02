package rs.novotek.movieapiplayground.features.latestmovies

import rs.novotek.domain.usecases.GetMovieUseCase
import rs.novotek.domain.util.SchedulerProvider
import rs.novotek.movieapiplayground.mvp.BasePresenter
import javax.inject.Inject

/**
 * Created by BX on 12/11/2017.
 */
class LatestMoviesPresenter @Inject constructor(private val schedulerProvider: SchedulerProvider, private val getMovieUseCase: GetMovieUseCase) : BasePresenter<LatestMoviesView>(), LatestMoviesContract.Presenter {

    override fun loadMovie(id: String) {
        disposables.add(getMovieUseCase.loadMovie(id)
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
                .doOnSubscribe { view?.showLoading() }
                .doFinally { view?.hideLoading() }
                .subscribe({ view?.onLoadMovieSuccess(it) }, { view?.onLoadMovieError(it) }))
    }

    override fun discoverMovies(pageNr: Int) {
        disposables.add(getMovieUseCase.discoverMovies(pageNr)
                .subscribeOn(schedulerProvider.backgroundThread())
                .observeOn(schedulerProvider.mainThread())
                .doOnSubscribe { view?.showLoading() }
                .doFinally { view?.hideLoading() }
                .subscribe({ view?.onDiscoverMoviesSuccess(it) }, { view?.onDiscoverMoviesError(it) }))
    }


/*
    override fun deleteNote(id: Long) {
        disposables.add(deleteNoteUseCase.delete(Note(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view?.onDeleteNoteSuccess() }, { view?.onDeleteNoteError(it) }))
    }
*/
}
