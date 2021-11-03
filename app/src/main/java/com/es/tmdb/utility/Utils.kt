package com.es.tmdb.utility

import android.content.res.Resources

class Utils () {
    fun dpToPx(dp:Int):Int{
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }
}