package com.edu.movie.data.source

import com.edu.movie.data.source.remote.OnFetchDataJsonListener
import com.edu.movie.utils.TrendingMoviesParams

interface MovieDataSource {
    /**
     *  Local
     */
    interface Local

    /**
     *  Remote
     */
    interface Remote {
        fun <T> getDataTrending(
            listener: OnFetchDataJsonListener<T>,
            trendingParams: TrendingMoviesParams
        )
    }
}
