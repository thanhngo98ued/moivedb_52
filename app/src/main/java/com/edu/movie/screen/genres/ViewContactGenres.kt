package com.edu.movie.screen.genres

import com.edu.movie.data.model.Genres

interface ViewContactGenres {
    interface View : ViewContactGenres {
        fun getGenresOnSuccess(genres: List<Genres>)

        fun onError(exception: Exception?)
    }
}
