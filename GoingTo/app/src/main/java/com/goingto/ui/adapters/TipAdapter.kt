package com.goingto.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goingto.R
import com.goingto.data.entities.Tip

class TipAdapter (private val context: Context, private var tips:MutableList<Tip>):
    RecyclerView.Adapter<TipAdapter.TipItem>() {

        inner class TipItem(itemView : View) : RecyclerView.ViewHolder(itemView){

            private lateinit var tvTip:TextView

            fun bindTo(tip:Tip){
                tvTip = itemView.findViewById(R.id.tvTip)

                tvTip.text = tip.text
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipItem {
        val view = LayoutInflater.from(context).inflate(R.layout.item_tip, parent, false)
        return TipItem(view)
    }

    override fun onBindViewHolder(holder: TipItem, position: Int) {
        holder.bindTo(tips[position])
    }

    override fun getItemCount(): Int {
        return tips.size
    }

    fun setItems(tips: MutableList<Tip>) {
        this.tips = tips
        notifyDataSetChanged()
    }
}


