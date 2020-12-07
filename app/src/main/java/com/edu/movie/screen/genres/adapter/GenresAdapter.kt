package com.edu.movie.screen.genres.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.R
import com.edu.movie.data.model.Genres

class GenresAdapter() :
    RecyclerView.Adapter<ItemGenresViewHolder>() {

    private var onMoreClickListener: ((Int, String) -> Unit)? = null
    private var onItemMoviesClickListener: ((Int) -> Unit)? = null
    private var genres = listOf<Genres>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGenresViewHolder {
        return ItemGenresViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_genres, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemGenresViewHolder, position: Int) {
        holder.registerMoreClickListener(onMoreClickListener)
        holder.registerItemMoviesClickListener(onItemMoviesClickListener)
        holder.binData(genres[position])
    }

    override fun getItemCount() = genres.size

    fun registerMoreClickListener(onMoreClickListener: ((Int, String) -> Unit)?) {
        this.onMoreClickListener = onMoreClickListener
    }

    fun registerItemMovieClickListener(onItemMovieClickListener: ((Int) -> Unit)) {
        onItemMoviesClickListener = onItemMovieClickListener
    }

    fun registerData(genres: List<Genres>) {
        this.genres = genres
        notifyDataSetChanged()
    }
}
