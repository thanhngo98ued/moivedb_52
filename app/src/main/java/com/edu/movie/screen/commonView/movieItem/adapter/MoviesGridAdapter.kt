package com.edu.movie.screen.commonView.movieItem.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.R
import com.edu.movie.data.model.MovieItem

class MoviesGridAdapter : RecyclerView.Adapter<ItemMovieGridViewHolder>() {
    private val movies = mutableListOf<MovieItem>()

    fun registerListMovies(listMovies: MutableList<MovieItem>) {
        movies.clear()
        movies.addAll(listMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieGridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie_grid_layout, parent, false)
        return ItemMovieGridViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemMovieGridViewHolder, position: Int) {
        holder.bindData(movies[position])
    }

    override fun getItemCount() = movies.size
}
