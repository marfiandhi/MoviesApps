package divascion.marfiandhi.movieapps.adapter.videos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.model.trailers.TrailersOfMovie
import kotlinx.android.synthetic.main.trailers_list.view.*

class TrailersAdapter(private val context: Context, private val trailer: List<TrailersOfMovie>, private val listener: (TrailersOfMovie) -> Unit)
    : RecyclerView.Adapter<TrailersAdapter.TrailerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TrailerViewHolder(LayoutInflater.from(context).inflate(R.layout.trailers_list, parent, false))

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        holder.bindItem(trailer[position], listener)
    }

    override fun getItemCount(): Int = trailer.size

    class TrailerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(trailer: TrailersOfMovie, listener: (TrailersOfMovie) -> Unit) {
            itemView.trailer_title.text = trailer.name
            val link = "http://img.youtube.com/vi/${trailer.query}/0.jpg"
            Picasso.get().load(link)
                .placeholder(android.R.color.black)
                .error(R.drawable.no_thumbnail)
                .into(itemView.thumbnail_video)
            itemView.setOnClickListener { listener(trailer) }
        }
    }

}