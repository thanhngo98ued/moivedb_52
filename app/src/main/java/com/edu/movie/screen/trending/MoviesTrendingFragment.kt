package com.edu.movie.screen.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.edu.movie.R
import com.edu.movie.utils.TrendingMoviesType

class MoviesTrendingFragment : Fragment() {
    private var trendingType: TrendingMoviesType? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            trendingType = it.getSerializable(ARGUMENT_TRENDING) as TrendingMoviesType?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_trending, container, false)
    }

    companion object {
        private const val ARGUMENT_TRENDING = "ARGUMENT_TRENDING"

        @JvmStatic
        fun newInstance(param: TrendingMoviesType) = MoviesTrendingFragment().apply {
            arguments = bundleOf(ARGUMENT_TRENDING to param)
        }
    }
}
