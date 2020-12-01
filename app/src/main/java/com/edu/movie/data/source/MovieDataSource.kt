package com.edu.movie.data.source

import com.edu.movie.data.source.remote.OnFetchDataJsonListener
import com.edu.movie.utils.TrendingMoviesType

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
            page: Int,
            trendingType: TrendingMoviesType,
            listener: OnFetchDataJsonListener<T>,
        )
    }
}
