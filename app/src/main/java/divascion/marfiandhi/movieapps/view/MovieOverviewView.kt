package divascion.marfiandhi.movieapps.view

import divascion.marfiandhi.movieapps.model.credits.CastOfMovies
import divascion.marfiandhi.movieapps.model.credits.CrewOfMovies

interface MovieOverviewView {
    fun showLoading()
    fun hideLoading()
    fun getCrew(data: List<CrewOfMovies>)
    fun getCast(data: List<CastOfMovies>)
    fun loadView()
}