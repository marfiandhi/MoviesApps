package divascion.marfiandhi.movieapps.model.movies

import com.google.gson.annotations.SerializedName

data class ListOfMoviesResponse (
    val results: List<ListOfMovies>,

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("total_pages")
    val totalPage: Int? = null
)