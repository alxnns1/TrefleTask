package com.alxnns1.trefle.service

import com.alxnns1.trefle.model.Plants
import retrofit2.http.GET

interface TrefleService {

    @GET("api/v1/plants?token=yrc4yHkqP1TMmFsSAnLoR_kuz3pY41ET0A22VP8nNQw")
    suspend fun getPlants(): Plants
}