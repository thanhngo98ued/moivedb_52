package com.edu.movie.data.source.remote.fetchjson

import com.edu.movie.data.model.ItemMovieSlider
import com.edu.movie.data.model.ItemMovieSliderEntry
import com.edu.movie.data.model.MovieEntry
import com.edu.movie.data.model.MovieItem
import org.json.JSONObject

class ParseJsonToModel {

    @Throws(Exception::class)
    fun parseJsonToMovieItem(jsonObject: JSONObject?): MovieItem? {
        jsonObject?.apply {
            return MovieItem(
                getInt(MovieEntry.ID),
                getString(MovieEntry.TITLE),
                getString(MovieEntry.IMAGE_URL),
                getDouble(MovieEntry.RATE)
            )
        }
        return null
    }

    @Throws(Exception::class)
    fun parseJsonToMovieItemSlider(jsonObject: JSONObject?): ItemMovieSlider? {
        jsonObject?.apply {
            return ItemMovieSlider(
                getInt(ItemMovieSliderEntry.ID),
                getString(ItemMovieSliderEntry.IMAGE_URL)
            )
        }
        return null
    }
}
