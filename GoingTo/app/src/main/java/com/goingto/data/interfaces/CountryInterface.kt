package com.goingto.data.interfaces


import com.goingto.data.entities.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryInterface {

    @GET("countries/{id}")
    fun getById(@Path("id") id: String): Call<Country>

    @GET("countries/")
    fun getAll(): Call<List<Country>>
}