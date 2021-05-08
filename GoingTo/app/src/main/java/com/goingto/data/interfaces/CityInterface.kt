package com.goingto.data.interfaces


import com.goingto.data.entities.City
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CityInterface {

    @GET("cities/{id}")
    fun getById(@Path("id") id: String): Call<City>
}