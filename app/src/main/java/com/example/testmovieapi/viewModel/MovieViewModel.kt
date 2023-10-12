package com.example.testmovieapi.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmovieapi.data.MovieItems
import com.example.testmovieapi.data.dailyBoxOffice.DailyBoxOfficeResponse
import com.example.testmovieapi.retrofit.Retrofit
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val client = Retrofit.movieService
    private lateinit var movieList: ArrayList<MovieItems>
    private var _movieListResult: MutableLiveData<List<MovieItems>> =
        MutableLiveData<List<MovieItems>>()
    val movieListResult: LiveData<List<MovieItems>>
        get() = _movieListResult

    //일일 박스오피스 순위 가져오기 : 가져오는 자료가 없을 경우 생각하기
    fun getRankingList(key: String, targetDt: String) = viewModelScope.launch {
        movieList = arrayListOf()
        val service = Retrofit.movieService
        service.getDailyBoxOffice(key, targetDt)
            .enqueue(object : retrofit2.Callback<DailyBoxOfficeResponse> {
                override fun onResponse(
                    call: Call<DailyBoxOfficeResponse>,
                    response: Response<DailyBoxOfficeResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.boxOfficeResult?.dailyBoxOfficeList?.forEach { item ->
                            val title = item.movieNm
                            val rank = item.rank
                            movieList.add(MovieItems(rank, title))
                        }
                    }
                }

                override fun onFailure(call: Call<DailyBoxOfficeResponse>, t: Throwable) {
                    Log.d("TAG", t.message.toString())
                }
            })

        _movieListResult.value = movieList

    }

}