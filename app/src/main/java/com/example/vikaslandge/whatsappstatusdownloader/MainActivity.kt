package com.example.vikaslandge.whatsappstatusdownloader

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.text.method.ScrollingMovementMethod
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.imagefullscreen.*
import kotlinx.android.synthetic.main.indiview.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         var lmanager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rview.layoutManager = lmanager
        //var glayout = GridLayoutManager(this,1)
        //rview.layoutManager = glayout
        rview.adapter = MyAdapter(this)
      var  fullScreenInd = intent.getStringExtra("fullScreenIndicator")


        cview!!.setOnClickListener {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
            supportActionBar!!.hide()

            cview!!.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            cview!!.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            cview!!.adjustViewBounds = false
            cview!!.scaleType = ImageView.ScaleType.FIT_XY

            if ("y" == fullScreenInd) {
                intent.putExtra("fullScreenIndicator", "")
            } else {
                intent.putExtra("fullScreenIndicator", "y")
            }
            this@MainActivity.startActivity(intent)
        }
    }
}
