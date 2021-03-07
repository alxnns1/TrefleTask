package com.alxnns1.trefle.plants

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.alxnns1.trefle.model.Plants
import com.alxnns1.trefle.service.PlantsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PlantsViewModel @Inject constructor(
    plantsRepository: PlantsRepository
) {
    val plantsData: LiveData<Plants> = liveData(Dispatchers.IO) {
        emit(plantsRepository.getPlants())
    }
}