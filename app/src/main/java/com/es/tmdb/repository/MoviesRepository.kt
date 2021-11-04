package com.es.tmdb.repository

import com.es.tmdb.model.MovieDetail
import com.es.tmdb.model.TrendMovies
import com.es.tmdb.network.ApiService
import javax.inject.Inject
import io.reactivex.rxjava3.core.Observable

class MoviesRepository @Inject constructor(private val apiService: ApiService) {
    fun getTrendMovies(page: Int): Observable<TrendMovies> {
        return apiService.getTrendMovies(page)
    }

    fun getMovieDetail(movieId:Int):Observable<MovieDetail>{
        return apiService.getMovieDetail(movieId)
    }
}