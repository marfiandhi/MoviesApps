package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.squareup.picasso.Picasso
import divascion.marfiandhi.movieapps.BuildConfig
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.adapter.PagerAdapter
import divascion.marfiandhi.movieapps.model.movies.ListOfMovies
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovie : AppCompatActivity() {

    private lateinit var movie: ListOfMovies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        movie = intent.getParcelableExtra("item")

        setSupportActionBar(toolbar_movie_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadContentFavoriteToolbar(movie)

        toolbar_movie_detail.setNavigationOnClickListener {
            onBackPressed()
        }

        tab_layout_movie_detail.setupWithViewPager(view_pager_movie_detail)

        setupViewPager(view_pager_movie_detail, "Overview", "Trailers",
            MovieOverviewFragment(),
            TrailerMovieFragment()
        )
    }

    private fun setupViewPager(pager: ViewPager?, firstTitle: String, secondTitle: String, firstFragment: Fragment, secondFragment: Fragment) {
        val adapter = PagerAdapter(supportFragmentManager)

        adapter.addFragment(firstFragment, firstTitle,"item", movie)

        adapter.addFragment(secondFragment, secondTitle,"item", movie)

        pager?.adapter = adapter
    }

    private fun loadContentFavoriteToolbar(data: ListOfMovies) {
        supportActionBar?.title = data.title
        Picasso.get().load("${BuildConfig.MOVIE_BACKPOSTER}${data.linkBackdropPoster}").into(movie_image)
        detail_movie_name.text = data.title
        detail_movie_release.text = data.releaseDate
    }
}
