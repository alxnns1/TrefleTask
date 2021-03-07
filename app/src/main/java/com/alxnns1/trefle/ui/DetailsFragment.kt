package com.alxnns1.trefle.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.alxnns1.trefle.R
import com.alxnns1.trefle.model.PlantsData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment(
    private val plant: PlantsData
) : Fragment(R.layout.fragment_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this).load(plant.image_url)
            .override(1000)
            .into(plant_details_image)
        plant_details_name.text = plant.scientific_name
        plant_details_family.text = plant.family
        plant_details_genus.text = "${plant.genus} (${plant.genus_id})"
        plant_details_bibliography.text = plant.bibliography
        plant_details_year.text = plant.year.toString()
        plant_details_author.text = plant.author
    }
}