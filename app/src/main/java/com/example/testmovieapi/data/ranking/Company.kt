package com.example.testmovieapi.data.ranking


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("companyCd")
    val companyCd: String,
    @SerializedName("companyNm")
    val companyNm: String
)