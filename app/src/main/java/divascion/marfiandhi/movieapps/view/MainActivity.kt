package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.R.id.navigation_now_playing
import divascion.marfiandhi.movieapps.R.id.navigation_upcoming
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_nav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                navigation_now_playing -> {
                    changeNowPlaying(savedInstanceState)
                    return@setOnNavigationItemSelectedListener true
                }
                navigation_upcoming -> {
                    toast("Kedua")
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
        main_bottom_nav.selectedItemId = navigation_now_playing
    }

    private fun changeNowPlaying(savedInstanceState: Bundle?) {
        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame, NowPlayingFragment(), NowPlayingFragment::class.simpleName)
                .commit()
        }
    }
}
