package com.example.vikaslandge.whatsappstatusdownloader


import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.slider.*


class FullScreenImageActivity : AppCompatActivity() {

    lateinit var images :ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slider)
       //val fullScreenImageView = findViewById<View>(R.id.fullScreenImageView) as ImageView
       var url = getIntent().getStringArrayListExtra("image_url");
            images = url
        var position = intent.getIntExtra("position",0)
        var  adapter : PagerAdapter = FullscreenImageAdapter(this, images)

        viewPager.adapter= adapter
        viewPager.currentItem = position
      //  Glide.with(this).load(url)
        //         .into(fullScreenImageView)


    }

}
