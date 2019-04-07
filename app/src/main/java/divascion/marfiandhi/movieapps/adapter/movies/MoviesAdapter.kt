package divascion.marfiandhi.movieapps.adapter.movies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import divascion.marfiandhi.movieapps.BuildConfig
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.model.movies.ListOfMovies
import kotlinx.android.synthetic.main.movie_list.view.*

class MoviesAdapter(private val context: Context, private val movies: List<ListOfMovies>, private val listener: (ListOfMovies) -> Unit)
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list, parent, false))

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindItem(movies[position], listener)
    }

    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(movies: ListOfMovies, listener: (ListOfMovies) -> Unit) {
            itemView.movie_title.text = movies.title
            itemView.movie_date.text = movies.releaseDate
            itemView.movie_description.text = movies.overview
            val rate = (movies.score!! /10)*5
            itemView.movie_rate_text.text = rate.toString()
            itemView.movie_rate.rating = rate
            Picasso.get().load("${BuildConfig.MOVIE_POSTER}${movies.linkPoster}").into(itemView.movie_poster)
            itemView.setOnClickListener { listener(movies) }
        }
    }

}