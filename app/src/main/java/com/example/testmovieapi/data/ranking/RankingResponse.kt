package com.example.testmovieapi.data.ranking


import com.google.gson.annotations.SerializedName

data class RankingResponse(
    @SerializedName("movieListResult")
    val movieListResult: MovieListResult
)