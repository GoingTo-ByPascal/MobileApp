package com.goingto.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.goingto.databinding.ActivityMainBinding
import com.goingto.databinding.ActivityReviewsBinding

class ReviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initListeners()
    }

    private fun initListeners() {
        TODO("Not yet implemented")
    }
}