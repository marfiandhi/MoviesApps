package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.R.id.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var button = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_bottom_nav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                navigation_now_playing -> {
                    if(button) {
//                        main_nested_scroll_view.fullScroll(0)
                    } else {
                        button = true
                        changeFragment(savedInstanceState, NowPlayingFragment())
                        return@setOnNavigationItemSelectedListener true
                    }
                }
                navigation_upcoming -> {
                    if(!button) {
//                        main_nested_scroll_view.fullScroll(0)
                    } else {
                        button = false
                        changeFragment(savedInstanceState, UpComingFragment())
                        return@setOnNavigationItemSelectedListener true
                    }
                }
            }
            false
        }
        main_bottom_nav.selectedItemId = navigation_now_playing
    }

    private fun changeFragment(savedInstanceState: Bundle?, fragment: Fragment) {
        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_frame, fragment)
                .commit()
        }
    }

}
