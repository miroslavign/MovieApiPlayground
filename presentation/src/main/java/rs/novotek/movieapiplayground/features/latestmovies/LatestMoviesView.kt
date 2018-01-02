package rs.novotek.movieapiplayground.features.latestmovies

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import butterknife.BindView
import rs.novotek.domain.model.discover.DiscoverMovies
import rs.novotek.domain.model.movie.Movies
import rs.novotek.movieapiplayground.MovieApiPlaygroundApp
import rs.novotek.movieapiplayground.R
import rs.novotek.movieapiplayground.mvp.BaseView
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
        //presenter.loadMovie("157336")
        presenter.discoverMovies(1)
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
    }

    override fun onDiscoverMoviesSuccess(movies: DiscoverMovies) {
        Log.d("loger", "movie is "+ movies.results.toString())
        tvMovieName.text = movies.results.toString()
    }

    override fun onLoadMovieError(throwable: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //Timber.e(throwable)
        //showMessage(R.string.notes_load_error)
    }

    override fun onDiscoverMoviesError(throwable: Throwable) {
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