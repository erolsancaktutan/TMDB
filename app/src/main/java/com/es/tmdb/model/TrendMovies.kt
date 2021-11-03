package com.es.tmdb.model

/**

 * * * * * * * * * * * * * * * * *
 *  Created by Erol Sancaktutan  *
 *    www.erolsancaktutan.com    *
 *   erolsancaktutan@gmail.com   *
 *            11/3/2021          *
 * * * * * * * * * * * * * * * * *

 */

data class TrendMovies(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: ArrayList<Movie>
)
data class Movie(val backdrop_path:String,
                 val genre_ids:List<Int>,
                 val original_language:String,
                 val original_title:String,
                 val poster_path:String,
                 val video:Boolean,
                 val vote_average:Double,
                 val vote_count:Int,
                 val overview:String,
                 val release_date:String,
                 val id:Int,
                 val title:String,
                 val adult:Boolean,
                 val popularity:Double,
                 val media_type:String
                 )