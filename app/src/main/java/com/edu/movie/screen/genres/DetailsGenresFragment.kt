package com.edu.movie.screen.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.edu.movie.R

class DetailsGenresFragment : Fragment() {

    private var idGenre: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idGenre = it.getInt(ARG_ID_GENRE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details_genres, container, false)
    }

    companion object {
        private const val ARG_ID_GENRE = "ARG_ID_GENRE"

        @JvmStatic
        fun newInstance(idGenre: Int?) =
            DetailsGenresFragment().apply {
                arguments = bundleOf(ARG_ID_GENRE to idGenre)
            }
    }
}
