package com.example.vikaslandge.whatsappstatusdownloader

import android.content.Context
import android.view.ViewGroup
import com.bumptech.glide.Glide
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.provider.MediaStore
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.graphics.Bitmap
import android.net.Uri
import java.io.File
import android.webkit.MimeTypeMap
import android.widget.*
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder
import com.bumptech.glide.request.RequestOptions
import com.github.chrisbanes.photoview.PhotoView
import com.google.android.exoplayer2.util.MimeTypes


class FullscreenImageAdapter :PagerAdapter{

       var  context :Context
       var images : ArrayList<String>
     lateinit var inflater: LayoutInflater

     constructor(context: Context, images:ArrayList<String>) :super(){
         this.context = context
         this.images = images
      }
     override fun isViewFromObject(p0: View, p1: Any): Boolean = p0 == p1 as RelativeLayout


    override fun getCount(): Int {

        return images.size

    }

      override fun instantiateItem(container: ViewGroup, position: Int): Any {

            var image : PhotoView
          inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater
          var view : View = inflater.inflate(R.layout.activity_full_screen_image,container ,false)
          image =view.findViewById(R.id.fullScreenImageView)
         // var video: VideoView = view.findViewById(R.id.videoview)
          //image.setBackgroundResource(images)
          val options = BitmapFactory.Options()
          options.inPreferredConfig = Bitmap.Config.ARGB_8888
           var file =File(images.get(position))
          var selecteduri = Uri.fromFile(file)
          val fileExtension = MimeTypeMap.getFileExtensionFromUrl(selecteduri.toString())
val mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension)

        Toast.makeText(context,
        "FileExtension: " + fileExtension + "n" +
        "MimeType: " + mimeType,
            Toast.LENGTH_LONG).show()

          var b = BitmapFactory.decodeFile(images.get(position),options)
          //var bmp= ThumbnailUtils.extractThumbnail(b,, )
         // image.setImageBitmap(b)
            if (mimeType=="image/jpeg") {
                Glide.with(context).load(images.get(position))
                        .into(image)
            }
          container.addView( view)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object`as RelativeLayout)
    }

}

