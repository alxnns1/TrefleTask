package com.alxnns1.trefle.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.alxnns1.trefle.R
import com.alxnns1.trefle.model.Plants
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment(
    private val viewModel: PlantsViewModel,
    private val onPlantClickListener: PlantsRecyclerViewAdapter.OnItemClickListener
) : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.plantsData.observe(viewLifecycleOwner, plantsLiveDataObserver())
        plant_list.adapter = PlantsRecyclerViewAdapter()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun plantsLiveDataObserver(): Observer<Plants> = Observer {
        (plant_list.adapter as PlantsRecyclerViewAdapter).apply {
            data = it.data
            listener = onPlantClickListener
            notifyDataSetChanged()
        }
    }
}