package com.alxnns1.trefle.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alxnns1.trefle.R
import com.alxnns1.trefle.model.PlantsData
import kotlinx.android.synthetic.main.item_plant_list.view.*

class PlantsRecyclerViewAdapter :
    RecyclerView.Adapter<PlantsRecyclerViewAdapter.PlantsViewHolder>() {

    var data: List<PlantsData> = listOf()
    lateinit var listener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant_list, parent, false)
        return PlantsViewHolder(itemView, listener)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PlantsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class PlantsViewHolder(
        itemView: View,
        private val listener: OnItemClickListener
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(plantsData: PlantsData) {
            itemView.plant_family.text = plantsData.family_common_name
            itemView.plant_species.text = plantsData.scientific_name
            itemView.setOnClickListener { listener.onItemClick(this, plantsData) }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(holder: PlantsViewHolder, plant: PlantsData)
    }
}