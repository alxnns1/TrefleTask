package com.alxnns1.trefle

import android.app.Application
import com.alxnns1.trefle.di.ApplicationComponent
import com.alxnns1.trefle.di.DaggerApplicationComponent

class MyApplication : Application() {
    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.create()
}