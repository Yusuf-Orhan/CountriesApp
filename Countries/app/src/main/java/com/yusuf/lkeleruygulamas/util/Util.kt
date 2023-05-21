package com.yusuf.lkeleruygulamas.util

import android.widget.ImageView
import com.bumptech.glide.Glide
fun ImageView.downloadFromUri(downloadUri : String?){

    //val options = RequestOptions().placeholder(circularProgressDrawable).error(R.drawable.baseline_error_24)

    downloadUri?.let {
        Glide.with(context).load(it).into(this)
    }
}
/*fun placeHolder(context: Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}


 */