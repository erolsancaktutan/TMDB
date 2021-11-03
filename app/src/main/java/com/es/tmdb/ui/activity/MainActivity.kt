package com.es.tmdb.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.es.tmdb.R
import com.es.tmdb.abstracts.BaseActivity
import com.es.tmdb.databinding.ActivityMainBinding
import com.es.tmdb.ui.adapter.MoviesAdapter
import com.es.tmdb.utility.DividerItemDecoration
import com.es.tmdb.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    var pageCount = 0
    private val moviesViewModel: MoviesViewModel by viewModels()
    lateinit var moviesAdapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createMovieListAdapter()
        setRVDivider()
        observeMovieList()
        moviesViewModel.getTrendMovies(pageCount + 1)
    }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    private fun createMovieListAdapter() {
        moviesAdapter = MoviesAdapter(moviesViewModel.movieList(), click = { movie ->

        })
        getViewBinding().moviesRV.adapter = moviesAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeMovieList() {
        moviesViewModel.movieList().observe(this, {
            moviesAdapter.notifyDataSetChanged()
        })
    }

    private fun setRVDivider() {
        val itemDec =
            DividerItemDecoration(this, R.drawable.divider, utils.dpToPx(16), utils.dpToPx(16))
        getViewBinding().moviesRV.addItemDecoration(itemDec)
    }
}