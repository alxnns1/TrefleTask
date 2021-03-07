package com.alxnns1.trefle.plants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alxnns1.trefle.MyApplication
import com.alxnns1.trefle.R
import com.alxnns1.trefle.model.Plants
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class PlantsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: PlantsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        (applicationContext as MyApplication).applicationComponent.inject(this)
        viewModel.plantsData.observe(this, plantsLiveDataObserver())
        plant_list.adapter = PlantsRecyclerViewAdapter()
    }

    private fun plantsLiveDataObserver(): Observer<Plants> = Observer {
        (plant_list.adapter as PlantsRecyclerViewAdapter).apply {
            data = it.data
            notifyDataSetChanged()
        }
    }
}