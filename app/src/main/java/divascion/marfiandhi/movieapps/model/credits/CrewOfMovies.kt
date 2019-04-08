package divascion.marfiandhi.movieapps.model.credits

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CrewOfMovies(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("job")
    val job: String? = null,

    @SerializedName("gender")
    val gender: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("profile_path")
    val linkProfile: String? = null
): Parcelable