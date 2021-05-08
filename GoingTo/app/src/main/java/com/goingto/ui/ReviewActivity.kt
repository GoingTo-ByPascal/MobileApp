package com.goingto.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.goingto.databinding.ActivityMainBinding
import com.goingto.databinding.ActivityReviewsBinding

class ReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewsBinding

    companion object{
        const val locatableId = "{locatableId}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(locatableId)

        if (id != null) {
            Log.d("Locatable ID: " , id)
        }

    }
}