package com.alxnns1.trefle.service

import javax.inject.Inject

class PlantsRepository @Inject constructor(
    private val trefleService: TrefleService
) {

    suspend fun getPlants() = trefleService.getPlants()
}