package com.es.tmdb.abstracts

import androidx.appcompat.app.AppCompatActivity
import com.es.tmdb.utility.Utils
import javax.inject.Inject

abstract class BaseActivity() : AppCompatActivity() {
    @Inject
    lateinit var utils: Utils

}