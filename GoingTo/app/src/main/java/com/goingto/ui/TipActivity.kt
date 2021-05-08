package com.goingto.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.goingto.databinding.ActivityTipsBinding

class TipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding

    companion object{
        const val locatableId = "{locatableId}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra(locatableId)

        if (id != null) {
            Log.d("Locatable ID: " , id)
        }

    }

}