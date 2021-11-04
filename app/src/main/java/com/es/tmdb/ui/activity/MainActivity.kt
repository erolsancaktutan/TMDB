package com.es.tmdb.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.es.tmdb.abstracts.BaseActivity
import com.es.tmdb.databinding.ActivityMainBinding
import com.es.tmdb.ui.adapter.MoviesAdapter
import com.es.tmdb.ui.fragment.DetailFragment
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
        setRVDivider(binding!!.moviesRV)
        observeMovieList()
        moviesViewModel.getTrendMovies(pageCount + 1)
    }
    private fun createMovieListAdapter() {
        binding!!.moviesRV.adapter = MoviesAdapter(moviesViewModel.movieList().value!!, click = { movieId ->
            val fragment: Fragment = DetailFragment.newInstance("result.name","profileImg,result.description")
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.addToBackStack("detail")
            transaction.add(android.R.id.content, fragment).commit()
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeMovieList() {
        moviesViewModel.movieList().observe(this, {
           binding!!.moviesRV.adapter!!.notifyDataSetChanged()
        })
    }

}