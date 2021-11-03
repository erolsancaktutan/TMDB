package com.es.tmdb.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.es.tmdb.abstracts.BaseActivity
import com.es.tmdb.databinding.ActivityMainBinding
import com.es.tmdb.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val moviesViewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        moviesViewModel.movieList().observe(this, Observer {

            var a = ""
        })
        moviesViewModel.getTrendMovies(1)

    }

    override fun getViewBinding()= ActivityMainBinding.inflate(layoutInflater)
}