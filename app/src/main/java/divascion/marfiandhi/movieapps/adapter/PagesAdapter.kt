package divascion.marfiandhi.movieapps.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import divascion.marfiandhi.movieapps.R
import kotlinx.android.synthetic.main.page_list.view.*

class PagesAdapter(private val context: Context, private val totalPage: Int, private val page: Int, private val listener: (Int) -> Unit)
    : RecyclerView.Adapter<PagesAdapter.PageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PageViewHolder(LayoutInflater.from(context).inflate(R.layout.page_list, parent, false))

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        holder.bindItem(position, page, listener)
    }

    override fun getItemCount(): Int = totalPage

    class PageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindItem(page: Int, fixedPage: Int, listener: (Int) -> Unit) {
            if(page==fixedPage) {
                itemView.isClickable = false
            }
            itemView.page_text.text = page.toString()
            itemView.setOnClickListener { listener(page) }
        }
    }
}