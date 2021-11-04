package com.es.tmdb.abstracts

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.es.tmdb.R
import com.es.tmdb.utility.DividerItemDecoration
import com.es.tmdb.utility.Utils
import javax.inject.Inject

abstract class BaseActivity() : AppCompatActivity() {
    @Inject
    lateinit var utils: Utils

    fun setRVDivider(rv:RecyclerView) {
        val itemDec =
            DividerItemDecoration(this, R.drawable.divider, utils.dpToPx(32), utils.dpToPx(16))
        rv.addItemDecoration(itemDec)
    }

}