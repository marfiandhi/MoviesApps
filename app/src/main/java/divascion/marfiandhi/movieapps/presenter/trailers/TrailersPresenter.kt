package divascion.marfiandhi.movieapps.presenter.trailers

import com.google.gson.Gson
import divascion.marfiandhi.movieapps.model.ApiRepository
import divascion.marfiandhi.movieapps.model.MovieDBApi
import divascion.marfiandhi.movieapps.model.trailers.TrailersOfMovieResponse
import divascion.marfiandhi.movieapps.utils.CoroutineContextProvider
import divascion.marfiandhi.movieapps.view.TrailersView
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TrailersPresenter (private val view: TrailersView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson,
                         private val context: CoroutineContextProvider = CoroutineContextProvider()
) {

    fun getTrailersMovie(id: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(
                    apiRepository
                        .doRequest(MovieDBApi.getTrailersMovie(id)),
                    TrailersOfMovieResponse::class.java
                )
            }
            view.getTrailers(data.await().results)
            view.hideLoading()
        }
    }
}