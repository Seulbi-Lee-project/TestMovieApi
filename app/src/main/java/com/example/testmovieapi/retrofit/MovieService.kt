package com.example.testmovieapi.retrofit

import com.example.testmovieapi.data.dailyBoxOffice.DailyBoxOfficeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("searchDailyBoxOfficeList.json")
    fun getDailyBoxOffice(
        @Query("key") apiKey: String,
        @Query("targetDt") targetDt: String
    ): Call<DailyBoxOfficeResponse>
}