package com.edu.movie.data.model

data class ItemMovieSlider(
    val id: Int?,
    val imageSliderUrl: String?
)

object ItemMovieSliderEntry {
    const val LIST_MOVIE = "results"
    const val ID = "id"
    const val IMAGE_URL = "backdrop_path"
}
