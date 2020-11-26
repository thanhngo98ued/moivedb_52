package com.edu.movie.data.source.remote

import com.edu.movie.data.source.MovieDataSource
import com.edu.movie.data.source.remote.fetchjson.GetJsonFromUrl
import com.edu.movie.utils.Constant
import com.edu.movie.utils.TrendingMoviesParams
import com.edu.movie.utils.TypeModel

class MovieRemoteDataSource : MovieDataSource.Remote {

    private val endPointParams = Constant.BASE_API_KEY + Constant.BASE_LANGUAGE

    private object Holder {
        val INSTANCE = MovieRemoteDataSource()
    }

    override fun <T> getDataTrending(
        listener: OnFetchDataJsonListener<T>,
        trendingParams: TrendingMoviesParams
    ) {
        val stringUrl =
            Constant.BASE_URL + trendingParams.path + endPointParams + Constant.BASE_PAGE + 1
        GetJsonFromUrl(listener, TypeModel.MOVIE_ITEM_TRENDING).execute(stringUrl)
    }

    companion object {
        val instance: MovieRemoteDataSource by lazy { Holder.INSTANCE }
    }
}
