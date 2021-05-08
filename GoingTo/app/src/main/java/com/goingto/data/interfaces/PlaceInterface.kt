package com.goingto.data.interfaces


import com.goingto.data.entities.Place
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceInterface {

    @GET("places/{id}")
    fun getById(@Path("id") id: String): Call<Place>
}