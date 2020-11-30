package com.edu.movie.screen.trending.apdapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.edu.movie.screen.trending.MoviesTrendingFragment
import com.edu.movie.utils.TrendingMoviesType

class TrendingPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = TrendingMoviesType.values().size

    override fun createFragment(position: Int): Fragment =
        MoviesTrendingFragment.newInstance(TrendingMoviesType.values()[position])
}
