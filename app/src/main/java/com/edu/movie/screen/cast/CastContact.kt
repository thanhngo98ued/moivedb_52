package com.edu.movie.screen.cast

import com.edu.movie.data.model.MovieItem
import com.edu.movie.screen.base.BasePresenter

interface CastContact {
    interface View {
        fun loadMoviesOnSuccess(movies: List<MovieItem>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getMovies(idCast: Int, page: Int)
    }
}
