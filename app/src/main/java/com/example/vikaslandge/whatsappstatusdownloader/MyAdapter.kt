package com.example.vikaslandge.whatsappstatusdownloader

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.io.File
import android.support.v4.view.ViewPager
import java.security.AccessController.getContext


class MyAdapter: RecyclerView.Adapter<MyHolder> {


    var mActivity:MainActivity? = null
    var files:Array<File>?=null
    var file:File?=null
    constructor(mActivity:MainActivity, files: Array<File>?) {
        this.mActivity = mActivity
        this.files = files

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        var inflater=LayoutInflater.from(mActivity)
        var view=inflater.inflate(R.layout.indiview,parent,false)

        return MyHolder(view)


    }

    override fun getItemCount(): Int {

        return files!!.size

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        var f: File = files!!.get(position)
        var list: ArrayList<String>? = ArrayList()
        for(i in 0..files!!.size-1){
            list!!.add(files!!.get(i).path)
        }
                //list!!.addAll(listOf(files!![position]))

        var p1 : Int
        p1 = holder.adapterPosition
        var b = BitmapFactory.decodeFile(f.path)
        var bmp= ThumbnailUtils.extractThumbnail(b,150,150 )
        holder.cView!!.setImageBitmap(bmp)
        holder.cView!!.setOnClickListener {
            var i = Intent( mActivity, FullScreenImageActivity::class.java)
            i.putExtra("image_url",list)
            i.putExtra("position",p1)
                mActivity!!.startActivity(i)


        }
        holder.name!!.movementMethod

        holder.name!!.text=f.name
        var by=f.length()
        holder.size!!.text=(by/1024).toString()+" kb"
        holder.del!!.setOnClickListener {

            f.delete()
            files=file!!.listFiles()

        }

    }
}