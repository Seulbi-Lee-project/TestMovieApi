package com.example.testmovieapi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmovieapi.BuildConfig
import com.example.testmovieapi.data.MovieItems
import com.example.testmovieapi.databinding.ActivityMainBinding
import com.example.testmovieapi.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val viewModel = MovieViewModel()
        var movieList = arrayListOf<MovieItems>()
        binding.mainButton.setOnClickListener {
            movieList.clear()
            val date = binding.dateEdit.text.toString()
            viewModel.getRankingList(BuildConfig.MOVIE_API_KEY, date)
            viewModel.movieListResult.observe(this) {
                binding.mainRecyclerView.adapter = DailyBoxOfficeAdapter(it)
                binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
            }
        }
    }
}
