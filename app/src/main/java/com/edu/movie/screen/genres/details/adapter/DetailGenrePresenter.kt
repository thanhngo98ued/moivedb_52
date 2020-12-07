package com.edu.movie.screen.genres.details.adapter

import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.source.remote.OnFetchDataJsonListener
import com.edu.movie.data.source.repository.MovieRepository

class DetailGenrePresenter(private val repository: MovieRepository) :
    ViewContactDetailsGenres.Presenter {

    private var view: ViewContactDetailsGenres.View? = null

    override fun onStart() {}

    override fun onStop() {
        view = null
    }

    override fun setView(view: ViewContactDetailsGenres.View?) {
        this.view = view
    }

    override fun getMoviesDetailsGenres(idDetails: Int, page: Int) {
        repository.getMoviesByIdGenre(
            idDetails,
            page,
            object : OnFetchDataJsonListener<List<MovieItem>> {
                override fun onSuccess(data: List<MovieItem>) {
                    view?.getDetailsGenresOnSuccess(data)
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            })
    }
}
