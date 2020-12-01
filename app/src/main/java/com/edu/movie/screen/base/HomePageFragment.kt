package com.edu.movie.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edu.movie.R
import com.edu.movie.screen.trending.TrendingFragment
import com.edu.movie.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_home_page.*

class HomePageFragment private constructor() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homePage -> {
                    textHeader.text = getText(R.string.movie)
                    true
                }
                R.id.trendingPage -> {
                    textHeader.text = getText(R.string.trending)
                    replaceFragment(TrendingFragment.newInstance(), R.id.homePageContainer)
                    true
                }
                R.id.genresPage -> {
                    textHeader.text = getText(R.string.genres)
                    true
                }
                R.id.favoritePage -> {
                    textHeader.text = getText(R.string.favorite)
                    true
                }
                else -> false
            }
        }
    }

    companion object {
        fun newInstance() = HomePageFragment()
    }
}
