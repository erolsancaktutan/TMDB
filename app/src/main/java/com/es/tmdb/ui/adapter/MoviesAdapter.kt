package com.es.tmdb.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.es.tmdb.R
import com.es.tmdb.model.Movie
import com.es.tmdb.ui.adapter.vh.MovieVH

class MoviesAdapter(
    var movieList: MutableLiveData<ArrayList<Movie>>,
    private val click: (result: Movie) -> Unit
) : RecyclerView.Adapter<MovieVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieVH(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.movie_item_layout,
            parent,
            false))

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        val character = movieList.value!![position]
        holder.bind(character)
        holder.itemView.setOnClickListener {
            click(movieList.value!![position])
        }
    }

    override fun getItemCount(): Int = movieList.value!!.size
}
