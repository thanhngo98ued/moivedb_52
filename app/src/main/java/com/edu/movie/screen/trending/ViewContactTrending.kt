package com.edu.movie.screen.trending

import com.edu.movie.data.model.MovieItem

interface ViewContactTrending {
    interface View {
        fun getMovieSuccess(listMovies: MutableList<MovieItem>)
        fun onError(exception: Exception?)
    }
}
