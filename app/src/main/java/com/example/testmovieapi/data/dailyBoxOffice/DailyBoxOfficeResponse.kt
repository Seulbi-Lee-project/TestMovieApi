package com.example.testmovieapi.data.dailyBoxOffice


import com.google.gson.annotations.SerializedName

data class DailyBoxOfficeResponse(
    @SerializedName("boxOfficeResult")
    val boxOfficeResult: BoxOfficeResult
)