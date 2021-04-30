package com.goingto.ui.geographics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.goingto.R
import com.goingto.data.remote.ApiClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    private fun searchCountries(){

        val countryInterface = ApiClient.build()
        val searchCountries = countryInterface?.getCountries()
        


    }
}
