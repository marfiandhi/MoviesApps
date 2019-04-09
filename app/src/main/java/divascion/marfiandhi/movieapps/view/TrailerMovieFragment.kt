package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.model.movies.ListOfMovies
import org.jetbrains.anko.design.snackbar

class TrailerMovieFragment : Fragment() {

    private lateinit var movies: ListOfMovies

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        snackbar(view!!,movies.title.toString())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        movies = arguments?.getParcelable("item")!!
        return inflater.inflate(R.layout.fragment_trailer_movie, container, false)
    }

}
