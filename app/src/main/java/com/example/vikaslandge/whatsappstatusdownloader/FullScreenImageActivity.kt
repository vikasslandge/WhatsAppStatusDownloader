package com.example.vikaslandge.whatsappstatusdownloader


import android.net.Uri
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import kotlinx.android.synthetic.main.slider.*
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import kotlinx.android.synthetic.main.exoplayer.*
//import sun.audio.AudioPlayer.player
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.util.Util.getUserAgent
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util


class FullScreenImageActivity : AppCompatActivity() {

    lateinit var images :ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exoplayer)
       //val fullScreenImageView = findViewById<View>(R.id.fullScreenImageView) as ImageView
       var url = getIntent().getStringArrayListExtra("image_url");
            images = url
        var position = intent.getIntExtra("position",0)

       /* val player = ExoPlayerFactory.newSimpleInstance(this)
        playerView.player = player
        // Produces DataSource instances through which media data is loaded.
        val dataSourceFactory = DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "whatsApp"))
// This is the MediaSource representing the media to be played.
        var uri = Uri.parse("/sdcard/Pictures/ urvashi.mp4")
        val videoSource = ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(uri)
// Prepare the player with the source.
       player.prepare(videoSource)
        player.playWhenReady = false*/
        var  adapter : PagerAdapter = FullscreenImageAdapter(this, images)

        viewPager.adapter= adapter
    viewPager.currentItem = position
      //  Glide.with(this).load(url)
        //         .into(fullScreenImageView)




    }

}
