package com.edu.movie.data.source.repository

import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.source.MovieDataSource
import com.edu.movie.data.source.local.MovieLocalDataSource
import com.edu.movie.data.source.remote.MovieRemoteDataSource
import com.edu.movie.data.source.remote.OnFetchDataJsonListener
import com.edu.movie.utils.TrendingMoviesParams

class MovieRepository private constructor(
    private val local: MovieDataSource.Local,
    private val remote: MovieDataSource.Remote
) {

    private object Holder {
        val INSTANCE = MovieRepository(
            local = MovieLocalDataSource.instance,
            remote = MovieRemoteDataSource.instance
        )
    }

    fun getListMovieTrending(
        listener: OnFetchDataJsonListener<MutableList<MovieItem>>,
        trendingMoviesParams: TrendingMoviesParams
    ) {
        remote.getDataTrending(listener, trendingMoviesParams)
    }

    companion object {
        val instance: MovieRepository by lazy { Holder.INSTANCE }
    }
}
