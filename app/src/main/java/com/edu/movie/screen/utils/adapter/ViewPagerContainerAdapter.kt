package com.edu.movie.screen.utils.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerContainerAdapter(
    fragmentManager: FragmentManager,
    private var fragments: MutableList<Fragment> = mutableListOf<Fragment>()
) : FragmentPagerAdapter(
    fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position]
}
