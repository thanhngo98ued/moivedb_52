package com.edu.movie.screen.genres.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.R
import com.edu.movie.data.model.Genres

class GenresAdapter(private val genres: List<Genres>) :
    RecyclerView.Adapter<ItemGenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemGenresViewHolder {
        return ItemGenresViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_genres, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemGenresViewHolder, position: Int) {
        holder.binData(genres[position])
    }

    override fun getItemCount() = genres.size
}
