package com.goingto.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.goingto.data.entities.Tip
import com.goingto.data.remote.ApiClient
import com.goingto.databinding.ActivityTipsBinding
import com.goingto.ui.adapters.TipAdapter
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding
    private lateinit var tipAdapter: TipAdapter
    private var tips: MutableList<Tip> = ArrayList()

    companion object{
        const val locatableId = "{locatableId}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = Integer.parseInt(intent.getStringExtra(locatableId))

        initViews(id)
    }

    private fun initViews(id:Int) {
        tipAdapter = TipAdapter(this, tips)
        binding.rvTips.adapter = tipAdapter
        binding.rvTips.layoutManager = LinearLayoutManager(this)
        searchTipsByLocatableId(id)
    }

    private fun searchTipsByLocatableId(id:Int) {
        var tipsResponse = ApiClient.tipBuilder()?.getById(id)

        tipsResponse?.enqueue(object : Callback<MutableList<Tip>>{
            override fun onResponse(call: Call<MutableList<Tip>>, response: Response<MutableList<Tip>>) {
                if (response.isSuccessful){

                    tips = response.body()!!
                    tipAdapter.setItems(tips)
                    val placeResponse = response?.body()
                    Log.d("Response", Gson().toJson(placeResponse))
                }
            }

            override fun onFailure(call: Call<MutableList<Tip>>, t: Throwable) {
                t?.printStackTrace()
            }

        })
    }

}