package divascion.marfiandhi.movieapps.view

import divascion.marfiandhi.movieapps.model.trailers.TrailersOfMovie

interface TrailersView {
    fun showLoading()
    fun hideLoading()
    fun getTrailers(data: List<TrailersOfMovie>)
}