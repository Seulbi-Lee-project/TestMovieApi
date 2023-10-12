package com.example.testmovieapi.data.ranking


import com.google.gson.annotations.SerializedName

data class MovieListResult(
    @SerializedName("movieList")
    val movieList: List<Movie>,
    @SerializedName("source")
    val source: String,
    @SerializedName("totCnt")
    val totCnt: Int
)