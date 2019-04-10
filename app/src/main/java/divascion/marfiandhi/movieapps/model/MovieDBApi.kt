package divascion.marfiandhi.movieapps.model

import android.net.Uri
import divascion.marfiandhi.movieapps.BuildConfig

object MovieDBApi {
    fun getMovie(page: String?, query: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("movie")
            .appendPath(query)
            .appendQueryParameter("api_key", BuildConfig.MOVIEDB_API_KEY)
            .appendQueryParameter("language", "en-US")
            .appendQueryParameter("page", page)
            .build()
            .toString()
    }

    fun getTrailersMovie(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("movie")
            .appendPath(id)
            .appendPath("videos")
            .appendQueryParameter("api_key", BuildConfig.MOVIEDB_API_KEY)
            .appendQueryParameter("language", "en-US")
            .build()
            .toString()
    }

    fun getCreditsMovie(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
            .appendPath("3")
            .appendPath("movie")
            .appendPath(id)
            .appendPath("credits")
            .appendQueryParameter("api_key", BuildConfig.MOVIEDB_API_KEY)
            .build()
            .toString()
    }
}