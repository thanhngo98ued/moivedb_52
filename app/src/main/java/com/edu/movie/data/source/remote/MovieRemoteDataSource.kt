package com.edu.movie.data.source.remote

import com.edu.movie.data.source.MovieDataSource
import com.edu.movie.data.source.remote.fetchjson.GetJsonFromUrl
import com.edu.movie.utils.Constant
import com.edu.movie.utils.TrendingMoviesType
import com.edu.movie.utils.TypeModel

class MovieRemoteDataSource : MovieDataSource.Remote {

    private val endPointParams = Constant.BASE_API_KEY + Constant.BASE_LANGUAGE

    private object Holder {
        val INSTANCE = MovieRemoteDataSource()
    }

    override fun <T> getDataTrending(
        page: Int,
        trendingType: TrendingMoviesType,
        listener: OnFetchDataJsonListener<T>
    ) {
        val stringUrl =
            Constant.BASE_URL + trendingType.path + endPointParams + Constant.BASE_PAGE + page
        GetJsonFromUrl(TypeModel.MOVIE_ITEM_TRENDING, listener).execute(stringUrl)
    }

    companion object {
        val instance by lazy { Holder.INSTANCE }
    }
}
