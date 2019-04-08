package divascion.marfiandhi.movieapps.presenter.credits

import com.google.gson.Gson
import divascion.marfiandhi.movieapps.MovieOverviewView
import divascion.marfiandhi.movieapps.model.ApiRepository
import divascion.marfiandhi.movieapps.model.MovieDBApi
import divascion.marfiandhi.movieapps.model.credits.CreditsOfMoviesResponse
import divascion.marfiandhi.movieapps.utils.CoroutineContextProvider
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class CreditsPresenter (private val view: MovieOverviewView,
                        private val apiRepository: ApiRepository,
                        private val gson: Gson,
                        private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getCreditsMovie(id: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository
                    .doRequest(MovieDBApi.getCreditsMovie(id)),
                    CreditsOfMoviesResponse::class.java
                )
            }
            view.getCast(data.await().cast)
            view.getCrew(data.await().crew)
            view.loadView()
            view.hideLoading()
        }
    }

}