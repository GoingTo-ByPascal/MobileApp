package com.goingto.data.interfaces

import com.goingto.data.entities.Review
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ReviewInterface {

    @GET("locatables/{locatableId}/reviews")
    fun getById(@Path("locatableId") id: Int): Call<MutableList<Review>>
}