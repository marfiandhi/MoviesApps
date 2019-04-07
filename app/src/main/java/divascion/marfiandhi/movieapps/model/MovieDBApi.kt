package divascion.marfiandhi.movieapps.model

import android.net.Uri
import divascion.marfiandhi.movieapps.BuildConfig

object MovieDBApi {
    /*fun getMovie(page: String?, query: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("movie")
            .appendPath(query)
            .appendQueryParameter("api_key", BuildConfig.MoVIEDB_API_KEY+Uri.decode("%26language%3Den-US%26page%3D")+page)
            .build()
            .toString()
    }*/

    fun getMovie(page: String?, query: String?): String {
        return "${BuildConfig.BASE_URL}3/movie/$query?api_key=${BuildConfig.MOVIEDB_API_KEY}&language=en-US&page=$page"
    }

    fun getMovieDetail(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("movie")
            .appendPath(id)
            .appendQueryParameter("api_key", BuildConfig.MOVIEDB_API_KEY+"&language=en-US")
            .build()
            .toString()
    }
}