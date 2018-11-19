package com.example.vikaslandge.whatsappstatusdownloader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    var files:Array<File>?=null
    var file:File?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var lmanager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //rview.layoutManager = lmanager
        var glayout = GridLayoutManager(this,3)
        rview.layoutManager = glayout

        var path="storage/sdcarda/WhatsApp/Media/WhatsApp Images/"
        file= File(path)

        if(!file!!.exists()){

            path="storage/emulated/0/Pictures/"//WhatsApp/Media/.statuses/"
            file= File(path)

        }

        files=file!!.listFiles()
        rview.adapter = MyAdapter(this, files)

        /*cview!!.setOnClickListener {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
            supportActionBar!!.hide()

            cview!!.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            cview!!.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            cview!!.adjustViewBounds = false
            cview!!.scaleType = ImageView.ScaleType.FIT_XY


        }*/
    }
}
