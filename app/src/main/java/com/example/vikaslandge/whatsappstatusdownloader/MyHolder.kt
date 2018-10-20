package com.example.vikaslandge.whatsappstatusdownloader

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyHolder: RecyclerView.ViewHolder {
    var cView: ImageView? = null
    var del: ImageView? = null
    var name: TextView? = null
    var size:TextView?  = null
    constructor(v: View) : super(v) {
        cView = v.findViewById(R.id.cview)
        del = v.findViewById(R.id.del)
        name = v.findViewById(R.id.name)
        size = v.findViewById(R.id.size)
    }
}