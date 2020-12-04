package com.edu.movie.screen.genres.adapteritem

import com.edu.movie.data.model.MovieItem

interface ViewContactItemGenres {
    interface View : ViewContactItemGenres {
        fun getMoviesOnSuccess(movies: List<MovieItem>)

        fun onError(exception: Exception?)
    }
}
