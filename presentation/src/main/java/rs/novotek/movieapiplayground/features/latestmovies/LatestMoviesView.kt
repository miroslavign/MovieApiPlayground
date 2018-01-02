package rs.novotek.movieapiplayground.features.latestmovies

import android.content.Context
import android.support.annotation.NonNull
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler
import rs.novotek.domain.model.Movies
import rs.novotek.movieapiplayground.MovieApiPlaygroundApp
import rs.novotek.movieapiplayground.R
import rs.novotek.movieapiplayground.di.AppDbModule
import rs.novotek.movieapiplayground.di.AppModule
import rs.novotek.movieapiplayground.mvp.BaseView
import java.util.logging.Logger
import javax.inject.Inject

/**
 * Created by BX on 11/30/2017.
 */

class LatestMoviesView : BaseView(), LatestMoviesContract.View {

    @BindView(R.id.tvMovieName)
    lateinit var tvMovieName: TextView

    override fun showLoading() {

        Log.d("", "something show")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        Log.d("", "something hide")
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*
    override fun onCreateView(@NonNull inflater: LayoutInflater, @NonNull container: ViewGroup): View {
        val view = inflater.inflate(R.layout.latest_movies_layout, container, false)
        (view.findViewById(R.id.tvHello) as TextView).text = "Hello World"
        return view
    }
    */

    @Inject
    lateinit var presenter: LatestMoviesPresenter

    //@BindView(R.id.recycler_view)
    //lateinit var recyclerView: RecyclerView

    //private lateinit var recyclerViewAdapter: NotesAdapter

    override fun injectDependencies() {
        DaggerLatestMovieComponent.builder()
                .latestMoviesModule(LatestMoviesModule())
                .appComponent(MovieApiPlaygroundApp.appComponent)
                .build()
                .inject(this)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        initRecyclerView(view.context)
        presenter.start(this)
        presenter.loadMovie("157336")
    }

    override fun onDetach(view: View) {
        super.onDetach(view)
        presenter.stop()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun onLoadMovieSuccess(movies: Movies) {
        Log.d("loger", "movie is "+ movies.originalTitle)
        tvMovieName.text = movies.originalTitle
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadMovieError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //Timber.e(throwable)
        //showMessage(R.string.notes_load_error)
    }

    private fun initRecyclerView(context: Context) {
        //recyclerView.layoutManager = LinearLayoutManager(context)
        //recyclerViewAdapter = NotesAdapter()
        //recyclerViewAdapter.onItemClick = { onNoteClicked(it)}
        //recyclerView.adapter = recyclerViewAdapter
    }

    private fun onNoteClicked(note: String) {
        /*
        val noteDetailView = NoteDetailView().apply {
            args.putLong(NoteDetailView.EXTRA_NOTE_ID, note.id)
        }
        router.pushController(RouterTransaction.with(noteDetailView)
                .pushChangeHandler(FadeChangeHandler())
                .popChangeHandler(FadeChangeHandler()))
                */
    }

    //@OnClick(R.id.fab)
    override fun onFabClicked() {
        //router.pushController(RouterTransaction.with(AddNoteView())
        //        .pushChangeHandler(FadeChangeHandler())
        //        .popChangeHandler(FadeChangeHandler()))
    }

    override fun getLayoutId() = R.layout.latest_movies_layout

    override fun getToolbarTitleId() = R.string.all_movies_title



}