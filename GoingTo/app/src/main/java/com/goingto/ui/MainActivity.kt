package com.goingto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.goingto.R
import com.goingto.data.entities.Place
import com.goingto.data.remote.ApiClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var etCharacter: EditText
    private lateinit var btPlaceSearch: Button
    private lateinit var tvName: TextView
    private lateinit var tvDescription: TextView
    private lateinit var ivImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        etCharacter = findViewById(R.id.etCharacter)
        btPlaceSearch = findViewById(R.id.btPlaceSearch)
        tvName = findViewById(R.id.tvName)
        tvDescription = findViewById(R.id.tvDescription)
        ivImage = findViewById(R.id.ivImage)
    }

    private fun initListeners() {
        btPlaceSearch.setOnClickListener{
            searchPlaceById()
        }
    }

    private fun searchPlaceById() {
        val name = etCharacter.text.toString()
        val place = ApiClient.placeBuilder()?.getById(name)

        place?.enqueue(object : Callback<Place> {
            override fun onResponse(call: Call<Place>, response: Response<Place>) {
                if (response.isSuccessful){


                    tvName.text = response.body()?.name
                    tvDescription.text = response.body()?.locatable?.description


                    val placeResponse = response?.body()
                    Log.d("Response", Gson().toJson(placeResponse))
                    Glide.with(this@MainActivity).load(response.body()?.image).into(ivImage)
                }
            }

            override fun onFailure(call: Call<Place>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }


}
