package com.edu.movie.screen.genres.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.data.model.Genres
import kotlinx.android.synthetic.main.item_genres.view.*

class ItemGenresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun binData(genres: Genres) {
        itemView.textNameGenres.text = genres.name
    }
}
