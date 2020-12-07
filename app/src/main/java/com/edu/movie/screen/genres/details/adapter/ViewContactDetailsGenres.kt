package com.edu.movie.screen.genres.details.adapter

import com.edu.movie.data.model.MovieItem
import com.edu.movie.screen.base.BasePresenter
import com.edu.movie.screen.genres.ViewContactGenres

interface ViewContactDetailsGenres {
    interface View : ViewContactGenres {
        fun getDetailsGenresOnSuccess(movies: List<MovieItem>)

        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {

        fun getMoviesDetailsGenres(idDetails: Int, page: Int)
    }
}
