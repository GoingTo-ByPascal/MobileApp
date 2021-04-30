package com.goingto.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://goingto-api.azurewebsites.net/"

    private var countryInterface: CountryInterface? = null

    fun build(): CountryInterface? {
        var builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        var retrofit: Retrofit = builder.build()
        countryInterface = retrofit.create(
            CountryInterface::class.java)
        return countryInterface as CountryInterface
    }
}