package com.example.testmovieapi.data.ranking


import com.google.gson.annotations.SerializedName

data class Director(
    @SerializedName("peopleNm")
    val peopleNm: String
)