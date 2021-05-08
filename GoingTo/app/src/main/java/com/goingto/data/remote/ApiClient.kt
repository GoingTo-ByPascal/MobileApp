package com.goingto.data.remote

import com.goingto.data.interfaces.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val API_BASE_URL = "https://goingto-api.azurewebsites.net/api/"

    private var countryInterface: CountryInterface? = null
    private var cityInterface: CityInterface? = null
    private var placeInterface: PlaceInterface? = null
    private var reviewInterface: ReviewInterface? = null
    private var tipInterface: TipInterface? = null

    private val builder = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun countryBuilder(): CountryInterface? {

        countryInterface = builder.create(CountryInterface::class.java)
        return countryInterface as CountryInterface

    }

    fun cityBuilder(): CityInterface? {

        cityInterface = builder.create(CityInterface::class.java)
        return cityInterface as CityInterface

    }

    fun placeBuilder(): PlaceInterface? {

        placeInterface = builder.create(PlaceInterface::class.java)
        return placeInterface as PlaceInterface

    }

    fun reviewBuilder(): ReviewInterface?{
        reviewInterface = builder.create(ReviewInterface::class.java)
        return reviewInterface as ReviewInterface
    }

    fun tipBuilder(): TipInterface?{
        tipInterface = builder.create(TipInterface::class.java)
        return tipInterface as TipInterface
    }

}