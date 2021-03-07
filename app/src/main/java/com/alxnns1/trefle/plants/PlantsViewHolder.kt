package com.alxnns1.trefle.plants

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alxnns1.trefle.model.PlantsData
import kotlinx.android.synthetic.main.item_plant_list.view.*

class PlantsViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(plantsData: PlantsData) {
        itemView.plant_family.text = plantsData.family_common_name
        itemView.plant_species.text = plantsData.scientific_name
    }
}
