package com.edu.movie.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.screen.commonView.movieItem.adapter.MoviesGridAdapter

fun RecyclerView.showIconLoadMore(adapterMovie: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    setHasFixedSize(true)
    adapter = adapterMovie
    val gridLayoutManager = (layoutManager as GridLayoutManager)
    gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int {
            return when (adapterMovie.getItemViewType(position)) {
                MoviesGridAdapter.TYPE_PROGRESSBAR -> gridLayoutManager.spanCount
                MoviesGridAdapter.TYPE_MOVIE_ITEM -> MoviesGridAdapter.TYPE_MOVIE_ITEM
                else -> Constant.DO_SOME_THING
            }
        }
    }
}
