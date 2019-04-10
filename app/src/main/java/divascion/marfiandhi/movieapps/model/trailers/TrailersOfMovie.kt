package divascion.marfiandhi.movieapps.model.trailers

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TrailersOfMovie(
    @SerializedName("id")
    val id: String? = null,

    @SerializedName("key")
    val query: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("site")
    val site: String? = null,

    @SerializedName("type")
    val type: String? = null
): Parcelable