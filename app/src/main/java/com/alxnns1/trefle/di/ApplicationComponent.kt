package com.alxnns1.trefle.di

import com.alxnns1.trefle.ui.PlantsActivity
import dagger.Component

@Component(modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: PlantsActivity)
}