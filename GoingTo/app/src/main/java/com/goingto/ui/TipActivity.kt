package com.goingto.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.goingto.databinding.ActivityReviewsBinding
import com.goingto.databinding.ActivityTipsBinding

class TipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initListeners()
    }

    private fun initListeners() {
        TODO("Not yet implemented")
    }
}