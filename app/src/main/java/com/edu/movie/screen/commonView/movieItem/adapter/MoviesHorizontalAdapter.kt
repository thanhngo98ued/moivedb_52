package com.edu.movie.screen.commonView.movieItem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.R
import com.edu.movie.data.model.MovieItem
import com.edu.movie.screen.commonView.movieItem.adapter.MovieViewHolder

class MoviesHorizontalAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movies: MutableList<MovieItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie_horizontal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.binData(movies[position])
    }

    override fun getItemCount() = movies.size

    fun registerData(movies: MutableList<MovieItem>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }
}
