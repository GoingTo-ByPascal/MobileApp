package com.goingto.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.goingto.data.entities.Review
import com.goingto.data.remote.ApiClient
import com.goingto.databinding.ActivityReviewsBinding
import com.goingto.ui.adapters.ReviewAdapter
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewsBinding
    private lateinit var reviewAdapter: ReviewAdapter
    private var reviews: MutableList<Review> = ArrayList()

    companion object{
        const val locatableId = "{locatableId}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = Integer.parseInt(intent.getStringExtra(locatableId))

        initViews(id)
    }

    private fun initViews(id: Int) {
        reviewAdapter = ReviewAdapter(this, reviews)
        binding.rvReviews.adapter = reviewAdapter
        binding.rvReviews.layoutManager = LinearLayoutManager(this)
        searchReviewsByLocatableId(id)
    }

    private fun searchReviewsByLocatableId(id: Int) {
        var reviewsResponse = ApiClient.reviewBuilder()?.getById(id)

        reviewsResponse?.enqueue(object: Callback<MutableList<Review>> {
            override fun onResponse(call: Call<MutableList<Review>>, response: Response<MutableList<Review>>)
            {
                if (response.isSuccessful){

                    reviews = response.body()!!
                    reviewAdapter.setItems(reviews)
                    val reviewResponse = response?.body()
                    Log.d("Response", Gson().toJson(reviewResponse))
                }
            }

            override fun onFailure(call: Call<MutableList<Review>>, t: Throwable) {
                t?.printStackTrace()
            }

        })
    }
}