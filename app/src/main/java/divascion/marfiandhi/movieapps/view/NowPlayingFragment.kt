package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.adapter.movies.MoviesAdapter
import divascion.marfiandhi.movieapps.model.ApiRepository
import divascion.marfiandhi.movieapps.model.movies.ListOfMovies
import divascion.marfiandhi.movieapps.presenter.movies.MoviesPresenter
import kotlinx.android.synthetic.main.fragment_now_playing.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity

@Suppress("DEPRECATION")
class NowPlayingFragment : Fragment(), MovieListView {

    private var movies: MutableList<ListOfMovies> = mutableListOf()

    private lateinit var presenter : MoviesPresenter
    private lateinit var adapter: MoviesAdapter

    private lateinit var page: String
    private val query = "now_playing"

    override fun showLoading() {
        current_movie_swipe.isRefreshing = true
    }

    override fun hideLoading() {
        current_movie_swipe.isRefreshing = false
    }

    override fun showMovies(data: List<ListOfMovies>) {
        movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_now_playing, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        page = "1"
        current_movie_swipe.setColorSchemeColors(resources.getColor(R.color.colorMaroon),
            resources.getColor(android.R.color.holo_red_light),
            resources.getColor(android.R.color.holo_orange_light),
            resources.getColor(android.R.color.holo_blue_light))

        recycler_current.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)

        adapter = MoviesAdapter(activity!!, movies) {
            startActivity<DetailsMovie>("item" to it)
        }

        recycler_current.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = MoviesPresenter(this, request, gson)
        presenter.getMovieList(page, query)

        current_movie_swipe.onRefresh {
            presenter.getMovieList(page, query)
        }
    }

}
