package com.es.tmdb.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.es.tmdb.R
import com.es.tmdb.abstracts.BaseActivity
import com.es.tmdb.databinding.ActivityMainBinding
import com.es.tmdb.model.Movie
import com.es.tmdb.ui.adapter.MoviesAdapter
import com.es.tmdb.utility.DividerItemDecoration
import com.es.tmdb.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null
    var pageCount = 0
    private val moviesViewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        createMovieListAdapter()
        setRVDivider()
        observeMovieList()
        moviesViewModel.getTrendMovies(pageCount + 1)
    }

    private fun createMovieListAdapter() {
        binding!!.moviesRV.adapter = MoviesAdapter(moviesViewModel.movieList().value!!, click = { movie ->

        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeMovieList() {
        moviesViewModel.movieList().observe(this, {
           binding!!.moviesRV.adapter!!.notifyDataSetChanged()
        })
    }

    private fun setRVDivider() {
        val itemDec =
            DividerItemDecoration(this, R.drawable.divider, utils.dpToPx(32), utils.dpToPx(16))
        binding!!.moviesRV.addItemDecoration(itemDec)
    }
}