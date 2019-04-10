package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.google.gson.Gson
import divascion.marfiandhi.movieapps.BuildConfig
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.adapter.videos.TrailersAdapter
import divascion.marfiandhi.movieapps.model.ApiRepository
import divascion.marfiandhi.movieapps.model.movies.ListOfMovies
import divascion.marfiandhi.movieapps.model.trailers.TrailersOfMovie
import divascion.marfiandhi.movieapps.presenter.trailers.TrailersPresenter
import kotlinx.android.synthetic.main.fragment_trailer_movie.*
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast


class TrailerMovieFragment : Fragment(), TrailersView{
    override fun showLoading() {
        trailer_swipe.isRefreshing = true
    }

    override fun hideLoading() {
        trailer_swipe.isRefreshing = false
    }

    override fun getTrailers(data: List<TrailersOfMovie>) {
        trailer.clear()
        trailer.addAll(data)
        adapter.notifyDataSetChanged()
    }

    private var trailer: MutableList<TrailersOfMovie> = mutableListOf()
    private lateinit var movies: ListOfMovies
    private lateinit var adapter: TrailersAdapter
    private lateinit var presenter : TrailersPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = TrailersAdapter(activity!!, trailer) {
            startActivity<YoutubeActivity>("item" to it)
        }
        recycler_trailer.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        recycler_trailer.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = TrailersPresenter(this, request, gson)
        presenter.getTrailersMovie(movies.id.toString())
        trailer_swipe.onRefresh {
            presenter.getTrailersMovie(movies.id.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        movies = arguments?.getParcelable("item")!!
        return inflater.inflate(R.layout.fragment_trailer_movie, container, false)
    }

}
