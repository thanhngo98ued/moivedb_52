package com.edu.movie.screen.genres.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.data.model.Genres
import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.source.repository.MovieRepository
import com.edu.movie.screen.commonView.movieItem.adapter.MoviesHorizontalAdapter
import com.edu.movie.screen.genres.adapteritem.ItemGenresPresenter
import com.edu.movie.screen.genres.adapteritem.ViewContactItemGenres
import kotlinx.android.synthetic.main.item_genres.view.*

class ItemGenresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
    ViewContactItemGenres.View {

    private var onItemMoreClickListener: ((Int) -> Unit)? = null
    private val adapterMovieGenres by lazy { MoviesHorizontalAdapter() }

    override fun getMoviesOnSuccess(movies: List<MovieItem>) {
        adapterMovieGenres.registerData(movies as MutableList<MovieItem>)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(itemView.context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    fun registerMoreClickListener(onItemMoreClickListener: ((Int) -> Unit)?) {
        this.onItemMoreClickListener = onItemMoreClickListener
    }

    fun registerItemMoviesClickListener(onItemMovieClickListener: ((Int) -> Unit)?) {
        onItemMovieClickListener?.let { adapterMovieGenres.registerOnItemClickListener(it) }
    }

    fun binData(genres: Genres) {
        itemView.textNameGenres.text = genres.name
        itemView.recyclerItemGenres.apply {
            setHasFixedSize(true)
            adapter = adapterMovieGenres
        }

        genres.id?.let { id ->
            itemView.linearLayoutGenres.setOnClickListener {
                onItemMoreClickListener?.invoke(id)
            }
            ItemGenresPresenter(MovieRepository.instance).apply {
                setView(this@ItemGenresViewHolder)
                getMoviesByIdGenre(id)
            }
        }
    }
}
