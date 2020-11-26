package com.edu.movie.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edu.movie.R
import com.edu.movie.screen.base.HomePageFragment
import com.edu.movie.utils.addFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(HomePageFragment.newInstance(), R.id.container)
    }
}
