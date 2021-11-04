package com.es.tmdb.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.es.tmdb.abstracts.BaseActivity
import com.es.tmdb.abstracts.PaginationListener
import com.es.tmdb.databinding.ActivityMainBinding
import com.es.tmdb.ui.adapter.MoviesAdapter
import com.es.tmdb.ui.fragment.DetailFragment
import com.es.tmdb.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private var binding: ActivityMainBinding? = null
    var pageCount = 0
    var isLoading = false
    var isLastPage = false
    private val moviesViewModel: MoviesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setScrollListener()
        createMovieListAdapter()
        setRVDivider(binding!!.moviesRV)
        observeMovieList()
        binding!!.loadingTV.visibility = View.VISIBLE
        moviesViewModel.getTrendMovies(pageCount + 1)
    }

    private fun createMovieListAdapter() {
        binding!!.moviesRV.adapter = MoviesAdapter(moviesViewModel.movieList().value!!, click = { movieId ->
            val fragment: Fragment = DetailFragment.newInstance(movieId)
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.addToBackStack("detail")
            transaction.add(android.R.id.content, fragment).commit()
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeMovieList() {
        moviesViewModel.movieList().observe(this, {
           binding!!.moviesRV.adapter!!.notifyDataSetChanged()
            binding!!.loadingTV.visibility = View.GONE
            isLoading = false
            isLastPage = false
        })
    }

    private fun setScrollListener(){
        binding!!.moviesRV.addOnScrollListener(object : PaginationListener(binding!!.moviesRV.layoutManager as LinearLayoutManager){
            override fun loadMoreItems() {
                isLoading = true
                isLastPage = true
                pageCount += 1
                moviesViewModel.getTrendMovies(pageCount)
                binding!!.loadingTV.visibility = View.VISIBLE
            }

            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }
        })
    }

}