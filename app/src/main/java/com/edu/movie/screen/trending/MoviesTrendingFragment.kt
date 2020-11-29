package com.edu.movie.screen.trending

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.edu.movie.R
import com.edu.movie.data.model.MovieItem
import com.edu.movie.data.source.repository.MovieRepository
import com.edu.movie.screen.commonView.movieItem.adapter.MoviesGridAdapter
import com.edu.movie.utils.Constant
import com.edu.movie.utils.TrendingMoviesType
import kotlinx.android.synthetic.main.recyclerview_gridlayout.*

class MoviesTrendingFragment : Fragment(), ViewContactTrending.View {

    private var trendingType: TrendingMoviesType? = null
    private val adapterTrendingMovies by lazy { MoviesGridAdapter() }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initPresenter()
    }

    override fun getMovieSuccess(listMovies: MutableList<MovieItem>) {
        adapterTrendingMovies.registerListMovies(listMovies)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {
        recyclerViewMoviesGrid.apply {
            setHasFixedSize(true)
            adapter = adapterTrendingMovies
        }
    }

    private fun initPresenter() {
        TrendingPresenter(MovieRepository.instance).apply {
            setView(this@MoviesTrendingFragment)
            trendingType?.let { getListMovie(Constant.DEFAULT_PAGE, it) }
        }
    }

    companion object {
        private const val ARGUMENT_TRENDING = "ARGUMENT_TRENDING"

        @JvmStatic
        fun newInstance(param: TrendingMoviesType) = MoviesTrendingFragment().apply {
            arguments = bundleOf(ARGUMENT_TRENDING to param)
        }
    }
}
