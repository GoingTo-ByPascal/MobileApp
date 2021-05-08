package com.goingto.data.interfaces

import com.goingto.data.entities.Tip
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TipInterface {

    @GET("locatables/{locatableId}/tips")
    fun getById(@Path("locatableId") id: String): Call<Tip>
}