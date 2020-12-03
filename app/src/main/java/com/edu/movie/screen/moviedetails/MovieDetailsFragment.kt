package com.edu.movie.screen.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.edu.movie.R

class MovieDetailsFragment : Fragment() {
    private var idMovieDetails: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idMovieDetails = it.getInt(ARG_ID_MOVIE_DETAIL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    companion object {
        private const val ARG_ID_MOVIE_DETAIL = "ARG_ID_MOVIE_DETAIL"

        @JvmStatic
        fun newInstance(id: Int) =
            MovieDetailsFragment().apply {
                arguments = bundleOf(ARG_ID_MOVIE_DETAIL to id)
            }
    }
}
