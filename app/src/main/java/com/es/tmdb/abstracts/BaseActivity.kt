package com.es.tmdb.abstracts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.es.tmdb.utility.Utils
import javax.inject.Inject

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {
    lateinit var binding : VB
    @Inject
    lateinit var utils: Utils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun getViewBinding(): VB
}