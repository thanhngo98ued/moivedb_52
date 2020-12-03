package com.edu.movie.screen.moviedetails

import com.edu.movie.data.model.Cast
import com.edu.movie.data.model.MovieDetails
import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.model.VideoYoutube

interface MovieDetailsContact {
    interface View {
        fun loadContentMovieOnSuccess(movieDetails: MovieDetails)
        fun loadCastsOnSuccess(casts: List<Cast>)
        fun loadVideoTrailerOnSuccess(video: VideoYoutube?)
        fun loadMoviesRecommendations(movies: List<MovieItem>)
        fun onError(exception: Exception?)
    }
}
