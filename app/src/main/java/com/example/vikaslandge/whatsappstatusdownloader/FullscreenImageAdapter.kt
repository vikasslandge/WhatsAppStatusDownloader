package com.example.vikaslandge.whatsappstatusdownloader

import android.content.Context
import android.widget.LinearLayout
import android.view.ViewGroup
import com.bumptech.glide.Glide
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.View
import android.widget.ImageView


class CustomPagerAdapter(internal var mContext: Context, internal var mResources: Array<String>) : PagerAdapter() {
    internal var mLayoutInflater: LayoutInflater

    init {
        mLayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return mResources.size
    }

   override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        Log.d(TAG,
                "instantiateItem() called with: container = [$container], position = [$position]")

        val itemView = mLayoutInflater.inflate(R.layout.indiview, container, false)

        Log.d(TAG, "load in gallery:" + mResources[position] + "#end")
        val ivPhoto = itemView.findViewById(R.id.fullScreenImageView) as ImageView

        if (mResources[position] != "") {
            Glide.with(mContext)
                    .load(mResources[position].trim { it <= ' ' })
                    //.crossFade()
                    .into(ivPhoto)
        }

        container.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        Log.d(TAG, "destroyItem() called with: " + "container = [" + container + "], position = [" + position
                + "], object = [" + `object` + "]")
        container.removeView(`object` as LinearLayout)
    }

    companion object {

        private val TAG = "ImageViewPage"
    }
}