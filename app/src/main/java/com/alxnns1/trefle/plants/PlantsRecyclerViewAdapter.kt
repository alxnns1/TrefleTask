package com.alxnns1.trefle.plants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alxnns1.trefle.R
import com.alxnns1.trefle.model.PlantsData

class PlantsRecyclerViewAdapter : RecyclerView.Adapter<PlantsViewHolder>() {

    var data: List<PlantsData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant_list, parent, false)
        return PlantsViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        holder.bind(data[position])
    }
}