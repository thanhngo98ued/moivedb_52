package com.edu.movie.screen.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edu.movie.R
import com.edu.movie.screen.trending.apdapter.TrendingPagerAdapter
import com.edu.movie.utils.TrendingMoviesType
import com.edu.movie.utils.upperString
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_trending.*

class TrendingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPaperTrending.adapter = TrendingPagerAdapter(this)
        TabLayoutMediator(tabLayoutTrending, viewPaperTrending) { tab, position ->
            tab.text = when (position) {
                TrendingMoviesType.TOP_RATED.ordinal -> upperString(R.string.top_rate)
                TrendingMoviesType.NOW_PLAYING.ordinal -> upperString(R.string.now_playing)
                TrendingMoviesType.UP_COMING.ordinal -> upperString(R.string.upcoming)
                TrendingMoviesType.POPULAR.ordinal -> upperString(R.string.popular)
                else -> null
            }
        }.attach()
    }

    companion object {

        fun newInstance() = TrendingFragment()
    }
}
