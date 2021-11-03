package com.es.tmdb.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.es.tmdb.abstracts.BaseActivity
import com.es.tmdb.databinding.ActivityMainBinding
import com.es.tmdb.ui.adapter.MoviesAdapter
import com.es.tmdb.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val moviesViewModel: MoviesViewModel by viewModels()
    lateinit var moviesAdapter : MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createMovieListAdapter()

        moviesViewModel.movieList().observe(this, {

            var a = ""
        })
        moviesViewModel.getTrendMovies(1)

    }
    override fun getViewBinding()= ActivityMainBinding.inflate(layoutInflater)
    private fun createMovieListAdapter(){
        moviesAdapter = MoviesAdapter(moviesViewModel.movieList(),click = {movie->

        })
    }
}