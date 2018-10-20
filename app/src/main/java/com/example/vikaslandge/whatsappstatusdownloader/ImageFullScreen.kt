package com.example.vikaslandge.whatsappstatusdownloader

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView

class FullScreenImageActivity : AppCompatActivity() {

    private var imageView: ImageView? = null
    private var fullScreenInd: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.imagefullscreen)

        val tb = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(tb)

        imageView = findViewById(R.id.imageView)
        imageView!!.setImageResource(R.drawable.abc_btn_borderless_material)

        fullScreenInd = intent.getStringExtra("fullScreenIndicator")
        if ("y" == fullScreenInd) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
            supportActionBar!!.hide()

            imageView!!.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            imageView!!.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            imageView!!.adjustViewBounds = false
            imageView!!.scaleType = ImageView.ScaleType.FIT_XY
        }

        imageView!!.setOnClickListener {
            val intent = Intent(this@FullScreenImageActivity,
                    FullScreenImageActivity::class.java)

            if ("y" == fullScreenInd) {
                intent.putExtra("fullScreenIndicator", "")
            } else {
                intent.putExtra("fullScreenIndicator", "y")
            }
            this@FullScreenImageActivity.startActivity(intent)
        }

    }
}