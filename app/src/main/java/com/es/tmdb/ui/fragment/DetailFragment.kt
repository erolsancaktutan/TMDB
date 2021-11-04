package com.es.tmdb.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.es.tmdb.R
import com.es.tmdb.abstracts.BaseFragment
import com.es.tmdb.databinding.FragmentDetailBinding
import com.es.tmdb.utility.Bindings
import com.es.tmdb.viewmodel.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val ARG_MOVIE_ID = "movieId"
@AndroidEntryPoint
class DetailFragment : BaseFragment() {
    private var binding: FragmentDetailBinding? = null
    private val moviesViewModel: MoviesViewModel by viewModels()
    private var movieId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getInt(ARG_MOVIE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeDetail()
        moviesViewModel.getMovieDetail(movieId!!)
    }

    private fun observeDetail(){
        moviesViewModel.movieDetail().observe(viewLifecycleOwner, { detail->
            binding!!.movie = detail
            //Bindings.loadImage(binding!!.posterIV,"https://image.tmdb.org/t/p/original${detail.poster_path}")
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(movId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_MOVIE_ID, movId)
                }
            }
    }
}