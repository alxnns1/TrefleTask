package com.alxnns1.trefle.di

import com.alxnns1.trefle.service.TrefleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideTrefleService(): TrefleService {
        return Retrofit.Builder()
            .baseUrl("https://trefle.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}