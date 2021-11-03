package com.es.tmdb.ui.adapter.vh

import androidx.recyclerview.widget.RecyclerView
import com.es.tmdb.databinding.MovieItemLayoutBinding
import com.es.tmdb.model.Movie

class MovieVH(private val itemViews: MovieItemLayoutBinding): RecyclerView.ViewHolder(itemViews.root) {
    fun bind(movie:Movie){
        itemViews.movie = movie
    }
}