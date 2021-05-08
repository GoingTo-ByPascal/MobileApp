package com.goingto.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.goingto.data.entities.Place
import com.goingto.data.remote.ApiClient
import com.goingto.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btTips.visibility

        var tipIntent = Intent(this,TipActivity::class.java)
        var reviewIntent = Intent(this,ReviewActivity::class.java)

        initViews()
        initListeners(tipIntent , reviewIntent)
    }

    private fun initViews() {
        btTips.visibility = View.INVISIBLE
        btReviews.visibility = View.INVISIBLE
        tvDescription.visibility = View.INVISIBLE
        tvName.visibility = View.INVISIBLE
    }

    private fun initListeners( tipIntent: Intent, reviewIntent: Intent) {
        binding.btPlaceSearch.setOnClickListener{
            searchPlaceById(tipIntent,reviewIntent)
            //Muestra vistas
            btTips.visibility = View.VISIBLE
            btReviews.visibility = View.VISIBLE
            tvDescription.visibility = View.VISIBLE
            tvName.visibility = View.VISIBLE
            //Log para ver si muestra todos
            searchAllPlaces()
        }
        binding.btReviews.setOnClickListener {
            openReviewActivity(reviewIntent)
        }
        binding.btTips.setOnClickListener {
            openTipActivity(tipIntent)
        }
    }

    private fun searchAllPlaces() {
        val places = ApiClient.placeBuilder()?.getAll()

        places?.enqueue(object : Callback<List<Place>> {
            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
                if (response.isSuccessful){

                    val placeResponse = response?.body()
                    Log.d("Response", Gson().toJson(placeResponse))
                }
            }

            override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }

    private fun openTipActivity(tipIntent: Intent) {
        startActivity(tipIntent)
    }

    private fun openReviewActivity(reviewIntent: Intent) {
        startActivity(reviewIntent)
    }

    private fun searchPlaceById(tipIntent: Intent, reviewIntent: Intent) {
        val name = binding.etCharacter.text.toString()
        val place = ApiClient.placeBuilder()?.getById(name)
        var locatableId = 0

        place?.enqueue(object : Callback<Place> {
            override fun onResponse(call: Call<Place>, response: Response<Place>) {
                if (response.isSuccessful){


                    binding.tvName.text = response.body()?.name
                    binding.tvDescription.text = response.body()?.locatable?.description

                    locatableId = response.body()?.locatable?.id!!
                    reviewIntent.putExtra(ReviewActivity.locatableId , locatableId.toString())
                    tipIntent.putExtra(TipActivity.locatableId , locatableId.toString())


                    val placeResponse = response?.body()
                    Log.d("Response", Gson().toJson(placeResponse))
                    Glide.with(this@MainActivity).load(response.body()?.image).into(binding.ivImage)
                }
            }

            override fun onFailure(call: Call<Place>, t: Throwable) {
                t?.printStackTrace()
            }
        })
    }


}
