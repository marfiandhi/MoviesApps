package divascion.marfiandhi.movieapps

import divascion.marfiandhi.movieapps.model.movies.ListOfMovies

interface MovieListView {
    fun showLoading()
    fun hideLoading()
    fun showMovies(data: List<ListOfMovies>)
}