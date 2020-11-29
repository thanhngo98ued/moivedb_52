package com.edu.movie.screen.trending

import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.source.remote.OnFetchDataJsonListener
import com.edu.movie.data.source.repository.MovieRepository
import com.edu.movie.screen.base.BasePresenter
import com.edu.movie.utils.TrendingMoviesType

class TrendingPresenter(private val movieRepository: MovieRepository) :
    BasePresenter<ViewContactTrending.View> {

    private var viewTrending: ViewContactTrending.View? = null

    override fun onStart() {}

    override fun onStop() {
        viewTrending = null
    }

    override fun setView(view: ViewContactTrending.View?) {
        this.viewTrending = view
    }

    fun getListMovie(
        page: Int,
        trendingMoviesType: TrendingMoviesType
    ) {
        movieRepository.getListMovieTrending(page, trendingMoviesType,
            object : OnFetchDataJsonListener<MutableList<MovieItem>> {
                override fun onSuccess(data: MutableList<MovieItem>) {
                    viewTrending?.getMovieSuccess(data)
                }

                override fun onError(exception: Exception?) {
                    viewTrending?.onError(exception)
                }
            }
        )
    }
}

