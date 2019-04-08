package divascion.marfiandhi.movieapps.model.movies

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ListOfMovies (
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("vote_average")
    val score: Float? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("poster_path")
    val linkPoster: String? = null,

    @SerializedName("genre_ids")
    val genre: Array<Int>? = null,

    @SerializedName("backdrop_path")
    val linkBackdropPoster: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("popularity")
    val popularity: Float? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null

):Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListOfMovies

        if (!Arrays.equals(genre, other.genre)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(genre)
    }
}