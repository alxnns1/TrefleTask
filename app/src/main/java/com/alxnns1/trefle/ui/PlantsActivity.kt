package com.alxnns1.trefle.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alxnns1.trefle.MyApplication
import com.alxnns1.trefle.R
import com.alxnns1.trefle.model.PlantsData
import javax.inject.Inject


class PlantsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: PlantsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plants)
        (applicationContext as MyApplication).applicationComponent.inject(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.plants_frame, ListFragment(viewModel, onPlantClickListener))
            .commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

    private val onPlantClickListener = object : PlantsRecyclerViewAdapter.OnItemClickListener {
        override fun onItemClick(
            holder: PlantsRecyclerViewAdapter.PlantsViewHolder,
            plant: PlantsData
        ) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.plants_frame, DetailsFragment(plant))
                .addToBackStack(null)
                .commit()
        }
    }
}