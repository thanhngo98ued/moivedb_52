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
import kotlinx.android.synthetic.main.fragment_genres.*

class GenresFragment : Fragment(), ViewContactGenres.View {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_genres, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    override fun getGenresOnSuccess(genres: List<Genres>) {
        recyclerViewGenres.adapter = GenresAdapter(genres)
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

    companion object {
        fun newInstance() = GenresFragment()
    }
}
