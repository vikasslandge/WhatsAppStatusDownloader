package com.example.vikaslandge.whatsappstatusdownloader


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


class FullScreenImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)
       val fullScreenImageView = findViewById<View>(R.id.fullScreenImageView) as ImageView
        var url = getIntent().getStringExtra("image_url");

        Glide.with(this).load(url)
                 .into(fullScreenImageView)


    }

}
