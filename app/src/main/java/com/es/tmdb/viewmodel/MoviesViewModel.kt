package com.es.tmdb.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.es.tmdb.model.Movie
import com.es.tmdb.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    var movieArr = ArrayList<Movie>()
    private val movies = MutableLiveData<ArrayList<Movie>>()

    init {
        movies.value = movieArr
    }

    fun movieList() = movies

    fun getTrendMovies(
        page: Int
    ) {
      moviesRepository.getTrendMovies(page)
          .subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({result->
              movieArr.addAll(result.results)
              movieList().postValue(movieArr)
          }, {})
    }
}