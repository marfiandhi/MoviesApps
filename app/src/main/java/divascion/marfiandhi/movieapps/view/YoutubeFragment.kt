package divascion.marfiandhi.movieapps.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import divascion.marfiandhi.movieapps.BuildConfig
import divascion.marfiandhi.movieapps.R
import divascion.marfiandhi.movieapps.model.trailers.TrailersOfMovie

class YoutubeFragment : Fragment(), YouTubePlayer.OnInitializedListener {

    private lateinit var trailer: TrailersOfMovie

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, youTubePlayer : YouTubePlayer?, b: Boolean) {
        youTubePlayer?.setFullscreen(true)
        youTubePlayer?.loadVideo(trailer.query)
        youTubePlayer?.play()
    }

    override fun onInitializationFailure(provider: YouTubePlayer.Provider?, youTubeInitializationResult : YouTubeInitializationResult?) {
        Log.e("YouTube", "Error")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        trailer = arguments?.getParcelable("item")!!
        return inflater.inflate(R.layout.fragment_youtube, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val youtubePlayerFragment = YouTubePlayerSupportFragment()
        youtubePlayerFragment.initialize(BuildConfig.GOOGLE_API_KEY, this)
        val fragmentManager = fragmentManager
        fragmentManager?.beginTransaction()?.replace(R.id.root_youtube_player, youtubePlayerFragment)?.commit()
    }

}
