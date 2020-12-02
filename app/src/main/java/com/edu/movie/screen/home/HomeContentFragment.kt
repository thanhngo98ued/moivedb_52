package com.edu.movie.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.edu.movie.R
import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.source.repository.MovieRepository
import com.edu.movie.screen.commomView.movieItem.adapter.MoviesHorizontalAdapter
import com.edu.movie.utils.TrendingMoviesType
import kotlinx.android.synthetic.main.fragment_home_content.*

class HomeContentFragment : Fragment(), ViewContactHome.View {

    private val popularAdapter by lazy { MoviesHorizontalAdapter() }
    private val upComingAdapter by lazy { MoviesHorizontalAdapter() }
    private val nowPlayingAdapter by lazy { MoviesHorizontalAdapter() }
    private val topRateAdapter by lazy { MoviesHorizontalAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_content, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initData()
    }

    override fun getMovieSuccess(
        listMovies: MutableList<MovieItem>,
        trendingMoviesType: TrendingMoviesType
    ) {
        when (trendingMoviesType) {
            TrendingMoviesType.POPULAR -> popularAdapter.registerData(listMovies)
            TrendingMoviesType.NOW_PLAYING -> nowPlayingAdapter.registerData(listMovies)
            TrendingMoviesType.UP_COMING -> upComingAdapter.registerData(listMovies)
            TrendingMoviesType.TOP_RATED -> topRateAdapter.registerData(listMovies)
        }
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_LONG).show()
    }

    private fun initRecyclerView() {
        applyRecyclerView(recyclerViewPopular, popularAdapter)
        applyRecyclerView(recyclerViewUpcoming, upComingAdapter)
        applyRecyclerView(recyclerViewNowPlaying, nowPlayingAdapter)
        applyRecyclerView(recyclerViewRate, topRateAdapter)
    }

    private fun initData() {
        HomePresenter(MovieRepository.instance).apply {
            setView(this@HomeContentFragment)
            onStart()
        }
    }

    private fun applyRecyclerView(
        recyclerView: RecyclerView,
        adapterMoviesHorizontalAdapter: MoviesHorizontalAdapter
    ) {
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = adapterMoviesHorizontalAdapter
        }
    }

    companion object {
        fun newInstance() = HomeContentFragment()
    }
}
