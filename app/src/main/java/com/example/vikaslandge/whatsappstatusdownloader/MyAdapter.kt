package com.example.vikaslandge.whatsappstatusdownloader

import android.content.Intent
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import com.example.vikaslandge.whatsappstatusdownloader.R.id.cview
import java.io.File

class MyAdapter: RecyclerView.Adapter<MyHolder> {


    var mActivity:MainActivity? = null
    var files:Array<File>?=null
    var file:File?=null
    constructor(mActivity:MainActivity) {
        this.mActivity = mActivity

        var path="storage/sdcarda/WhatsApp/Media/WhatsApp Images/"
        file= File(path)

        if(!file!!.exists()){

            path="storage/emulated/0/WhatsApp/Media/.statuses/"
            file= File(path)

        }

        files=file!!.listFiles()
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

        var b = BitmapFactory.decodeFile(f.path)
        var bmp= ThumbnailUtils.extractThumbnail(b,150,150 )
        holder.cView!!.setImageBitmap(bmp)
        holder.cView!!.setOnClickListener {
            var i = Intent( mActivity, FullScreenImageActivity::class.java)
            i.putExtra("image_url",f.path)
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