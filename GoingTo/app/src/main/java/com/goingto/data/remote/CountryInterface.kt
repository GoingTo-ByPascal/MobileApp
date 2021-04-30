package com.goingto.data.remote


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CountryInterface {

    @GET("api/countries")
    fun getCountries(): Call<ApiResponse>
}