package com.es.tmdb.network

import com.es.tmdb.model.TrendMovies
import io.reactivex.rxjava3.core.Observable

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("trending/movie/week")
    fun getTrendMovies(
        @Query("page") page: Int
    ): Observable<TrendMovies>
}