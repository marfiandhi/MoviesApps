package divascion.marfiandhi.movieapps.presenter.movies

import com.google.gson.Gson
import divascion.marfiandhi.movieapps.view.MovieListView
import divascion.marfiandhi.movieapps.model.ApiRepository
import divascion.marfiandhi.movieapps.model.MovieDBApi
import divascion.marfiandhi.movieapps.model.movies.ListOfMoviesResponse
import divascion.marfiandhi.movieapps.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MoviesPresenter(private val view: MovieListView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson,
                      private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getMovieList(page: String?, query: String?) {
        view.showLoading()
        async(context.main){
            val data = bg {
                gson.fromJson(apiRepository
                    .doRequest(MovieDBApi.getMovie(page, query)),
                    ListOfMoviesResponse::class.java
                )
            }
            view.showMovies(data.await().results)
            view.hideLoading()
        }
    }

}