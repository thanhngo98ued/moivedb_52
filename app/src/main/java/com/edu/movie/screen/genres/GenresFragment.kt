package com.edu.movie.screen.genres

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.edu.movie.R
import com.edu.movie.data.model.Genres
import com.edu.movie.data.source.repository.MovieRepository
import com.edu.movie.screen.genres.adapter.GenresAdapter
import com.edu.movie.screen.genres.details.DetailsGenresFragment
import com.edu.movie.screen.moviedetails.MovieDetailsFragment
import com.edu.movie.utils.addFragment
import kotlinx.android.synthetic.main.fragment_genres.*
import kotlinx.android.synthetic.main.item_genres.*

class GenresFragment : Fragment(), ViewContactGenres.View {

    private val genreAdapter by lazy { GenresAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initData()
        onClickMoreItem()
    }

    override fun getGenresOnSuccess(genres: List<Genres>) {
        genreAdapter.registerData(genres)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(context, exception?.message, Toast.LENGTH_LONG).show()
    }

    private fun initData() {
        GenresPresenter(MovieRepository.instance).apply {
            setView(this@GenresFragment)
            onStart()
        }
    }

    private fun initRecyclerView() {
        recyclerViewGenres.apply {
            setHasFixedSize(true)
            adapter = genreAdapter
        }
    }

    private fun onClickMoreItem() {
        genreAdapter.apply {
            registerMoreClickListener { id, name ->
                addFragment(DetailsGenresFragment.newInstance(id, name), R.id.container)
            }
            registerItemMovieClickListener {
                addFragment(MovieDetailsFragment.newInstance(it), R.id.container)
            }
        }
    }

    companion object {
        fun newInstance() = GenresFragment()
    }
}
