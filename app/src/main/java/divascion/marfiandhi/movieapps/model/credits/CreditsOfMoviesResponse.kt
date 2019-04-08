package divascion.marfiandhi.movieapps.model.credits

data class CreditsOfMoviesResponse (
    val cast: List<CastOfMovies>,
    val crew: List<CrewOfMovies>
)