package com.goingto.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goingto.R
import com.goingto.data.entities.Review


class ReviewAdapter (private val context: Context, private var reviews:MutableList<Review>):
    RecyclerView.Adapter<ReviewAdapter.ReviewItem>() {

    inner class ReviewItem(itemView : View) : RecyclerView.ViewHolder(itemView){

        private lateinit var tvReview: TextView

        fun bindTo(review: Review){
            tvReview = itemView.findViewById(R.id.tvReview)

            tvReview.text = review.comment
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewItem {
        val view = LayoutInflater.from(context).inflate(R.layout.item_review, parent, false)
        return ReviewItem(view)
    }

    override fun onBindViewHolder(holder: ReviewItem, position: Int) {
        holder.bindTo(reviews[position])
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    fun setItems(reviews: MutableList<Review>) {
        this.reviews = reviews
        notifyDataSetChanged()
    }
}