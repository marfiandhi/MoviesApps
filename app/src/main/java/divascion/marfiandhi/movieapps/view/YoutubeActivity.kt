package divascion.marfiandhi.movieapps.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.model.trailers.TrailersOfMovie

class YoutubeActivity : AppCompatActivity() {

    private lateinit var trailer: TrailersOfMovie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)
        trailer = intent.getParcelableExtra("item")
        changeFragment(savedInstanceState, YoutubeFragment(), "item", trailer)
    }

    private fun changeFragment(savedInstanceState: Bundle?, fragment: Fragment, key: String, value: TrailersOfMovie) {
        if(savedInstanceState == null) {
            val bundle =  Bundle()
            bundle.putParcelable(key, value)
            fragment.arguments = bundle
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.youtube_frame, fragment)
                .commit()
        }
    }
}
